package com.bagrivikas.accounts.service.impl;

import com.bagrivikas.accounts.dto.CustomerDto;
import com.bagrivikas.accounts.repository.AccountsRepository;
import com.bagrivikas.accounts.repository.CustomerRepository;
import com.bagrivikas.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

    }

}
