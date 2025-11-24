package FirstProject.BankingApp.controller;

import FirstProject.BankingApp.dto.AccountDto;
import FirstProject.BankingApp.repository.AccountRepo;
import FirstProject.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /// Add account Rest Api====> first we need to make method and then we ll make that method rest api using spring annotation

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        /// The Method Signature
        /// public ResponseEntity<AccountDto> addAccount(AccountDto accountDto)
        /// public: The method can be accessed from outside the class, usually by the Spring framework's dispatcher servlet.

        /// ResponseEntity<AccountDto>: This indicates the method is designed to return a complete HTTP response object.
        /// This object encapsulates not just the data (AccountDto),
        /// but also the HTTP status code (e.g., 201 Created, 400 Bad Request) and any headers.
        /// This gives the developer full control over the response sent back to the client.

        /// addAccount: The name of the method, likely mapped to a specific URL path and HTTP verb (e.g., @PostMapping("/accounts")).
        /// (AccountDto accountDto): This is the input parameter. AccountDto stands for Data Transfer Object,
        /// a simple object used to pass data between processes. Spring will automatically de-serialize (convert) the incoming request
        /// body (usually JSON) into an instance of the AccountDto class.
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
        /// This single line orchestrates the core logic:
        /// accountService.createAccount(accountDto): This is the core business logic call.
        /// The accountService is a dependency (likely injected via @Autowired or constructor injection) that handles the actual
        /// creation of the account. This service layer is responsible for:Validating the input data (accountDto).
        /// Converting the DTO into a persistence entity (e.g., an Account entity).
        /// Saving the entity to the database (e.g., using a repository).
        /// Returning the newly created (and potentially updated with an ID from the database) account DTO back to the controller.
        /// new ResponseEntity<>(...): This constructs the final HTTP response object.
        /// The first argument is the body of the response (the newly created AccountDto returned from the service layer).
        /// The second argument, HttpStatus.CREATED, is a standard HTTP status code (201). By explicitly setting this status,
        /// the server informs the client that the request was successfully fulfilled and resulted in the creation of a new resource.
    }


}
