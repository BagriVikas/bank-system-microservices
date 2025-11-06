package com.bagrivikas.accounts.service.impl;

import com.bagrivikas.accounts.dto.AccountsDto;
import com.bagrivikas.accounts.dto.CardsDto;
import com.bagrivikas.accounts.dto.CustomerDetailsDto;
import com.bagrivikas.accounts.dto.LoansDto;
import com.bagrivikas.accounts.entity.Accounts;
import com.bagrivikas.accounts.entity.Customer;
import com.bagrivikas.accounts.exception.ResourceNotFoundException;
import com.bagrivikas.accounts.mapper.AccountsMapper;
import com.bagrivikas.accounts.mapper.CustomerMapper;
import com.bagrivikas.accounts.repository.AccountsRepository;
import com.bagrivikas.accounts.repository.CustomerRepository;
import com.bagrivikas.accounts.service.ICustomersService;
import com.bagrivikas.accounts.service.client.CardsFeignClient;
import com.bagrivikas.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
