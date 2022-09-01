package io.clanga.paymentservice;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import io.clanga.gamesshared.payment.Account;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long accountNumber) {
        return accountRepository.findById(accountNumber);
    }

    public Boolean withdraw(Long accountNumber, Long amount) {
        val acct = accountRepository.findById(accountNumber);
        if (acct.isPresent()) {
            val tmp = acct.get();
            if (tmp.getBalance() - amount >= 0) {
                tmp.setBalance(tmp.getBalance() - amount);
                accountRepository.save(tmp);
                return true;
            }
        }
        return false;
    }

    public Boolean deposit(Long accountNumber, Long amount) {
        val acct = accountRepository.findById(accountNumber);
        if (acct.isPresent()) {
            val tmp = acct.get();
            tmp.setBalance(tmp.getBalance() + amount);
            accountRepository.save(tmp);
            return true;
        }
        return false;
    }
}
