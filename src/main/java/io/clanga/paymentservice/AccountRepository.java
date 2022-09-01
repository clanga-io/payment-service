package io.clanga.paymentservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.clanga.gamesshared.payment.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
