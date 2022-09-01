package io.clanga.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import io.clanga.gamesshared.payment.Account;

@RestController
@RequestMapping("/payment-service/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    // Create
    @PostMapping("/accounts")
    public Account createAccount(@RequestBody final Account account) {
        return accountService.createAccount(account);
    }

    // Retrieve
    @GetMapping("/accounts/{accountNumber}")
    public Optional<Account> getAccount(@PathVariable Long accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    // Update
    @PostMapping("/accounts/{accountNumber}/withdraw/{amount}")
    public Boolean withdraw(@PathVariable Long accountNumber, @PathVariable Long amount) {
        return accountService.withdraw(accountNumber, amount);
    }

    @PostMapping("/accounts/{accountNumber}/deposit/{amount}")
    public Boolean deposit(@PathVariable Long accountNumber, @PathVariable Long amount) {
        return accountService.deposit(accountNumber, amount);
    }
}
