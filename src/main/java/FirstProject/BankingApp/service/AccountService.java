package FirstProject.BankingApp.service;


import FirstProject.BankingApp.dto.AccountDto;
import FirstProject.BankingApp.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id );
    /// Long id ===> parameter

    AccountDto deposit(Long id, Double amount);

    AccountDto withdraw(Long id, Double amount);

    List<AccountDto> getAllAccounts();



}
