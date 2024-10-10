package com.project.banking_application.service;

import com.project.banking_application.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountByID(Long id);
    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto>getAllAccounts();
    void deleteAccount(Long id);
}
