package com.project.banking_application.controller;

import com.project.banking_application.dto.AccountDto;
import com.project.banking_application.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    // Constructor injection
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping  // This annotation specifies that this method handles POST requests
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // GET Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto>getAccountbyId(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountByID(id);
        return ResponseEntity.ok(accountDto);
    }

    // deposit REST api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id,@RequestBody Map<String,Double>request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw REST api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    // get all acounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>>getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // delete account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }
}
