package FirstProject.BankingApp.service.impl;

import FirstProject.BankingApp.dto.AccountDto;
import FirstProject.BankingApp.entity.Account;
import FirstProject.BankingApp.mapper.AccountMapper;
import FirstProject.BankingApp.repository.AccountRepo;
import FirstProject.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    /// all the implementation under this class
    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    /// createAccount method will call the accountRepo to save the account into the database
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountMapper.mapToAccountDto(account);
    }

    /// CREATE ACCOUNT METHOD TO CONVERT THE ACCOUNT DTO INTO ACCOUNT JPA ENTITY
    /// AND THEN SAVE THE JPA ENTITY INTO DATA BASE             ===================>>>> CONVERSION LOGIC(MAPPER)


}
