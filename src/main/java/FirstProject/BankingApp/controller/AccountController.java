package FirstProject.BankingApp.controller;

import FirstProject.BankingApp.dto.AccountDto;
import FirstProject.BankingApp.repository.AccountRepo;
import FirstProject.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")       /// base url
public class AccountController {

    /// injecting the dependency
    @Autowired
    private AccountService accountService;

    /// use contructor based dependency injection to inject AccountService

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /// Add account Rest Api ====> first we need to make method and then we ll make that method rest api using spring annotation

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }

    /// get account Rest Api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
      AccountDto accountDto = accountService.getAccountById(id);
      return ResponseEntity.ok(accountDto);
    }

    /// Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");

        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    /// Withdraw Rest API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");

        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    /// Get All Accounts Rest Api
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        return  ResponseEntity.ok(allAccounts);
    }




}
