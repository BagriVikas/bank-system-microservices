package com.bagrivikas.accounts.service;

import com.bagrivikas.accounts.dto.AccountsDto;
import com.bagrivikas.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto: CustomerDto object
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);

}
