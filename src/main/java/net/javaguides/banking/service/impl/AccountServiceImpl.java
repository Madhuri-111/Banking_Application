package net.javaguides.banking.service.impl;

//import net.javaguides.banking.
//import net.javaguides.banking.dto.AccountDto;
//import net.javaguides.banking.entity.Account;
//import net.javaguides.banking.mapper.AccountMapper;
//import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    public AccountDto getAccountById(Long id){
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account doesn't exists."));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("User doesn't exists!"));
        account.setBalance(account.getBalance() + amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("User doesn't exists!"));
        accountRepository.deleteById(id);
    }


}
