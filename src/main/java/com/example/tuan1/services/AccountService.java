package com.example.tuan1.services;

import com.example.tuan1.models.Account;
import com.example.tuan1.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }



}
