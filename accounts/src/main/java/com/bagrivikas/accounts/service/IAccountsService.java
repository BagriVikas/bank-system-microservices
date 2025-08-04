package com.bagrivikas.accounts.service;

import com.bagrivikas.accounts.dto.AccountsDto;
import com.bagrivikas.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto: CustomerDto object
     */
    void createAccount(CustomerDto customerDto);

}
