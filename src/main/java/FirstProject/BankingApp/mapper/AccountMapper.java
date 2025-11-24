package FirstProject.BankingApp.mapper;

import FirstProject.BankingApp.dto.AccountDto;
import FirstProject.BankingApp.entity.Account;

public class AccountMapper {

    /// converting account dto into jpa entity
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getBalance()
        );
        return account;
    }

    /// converting account jp entity into account dto
    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getName(),
                account.getBalance()
        );
        return accountDto;
    }

}
