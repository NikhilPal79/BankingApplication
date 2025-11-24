package FirstProject.BankingApp.service;


import FirstProject.BankingApp.dto.AccountDto;
import FirstProject.BankingApp.entity.Account;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id );
    /// Long id ===> parameter


}
