package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    void deleteAccount(Long id);
}
