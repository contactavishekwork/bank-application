package exp.avishek.bankapplication.service;

import exp.avishek.bankapplication.exceptions.UnableToFindAccountException;
import exp.avishek.bankapplication.model.Account;

import java.math.BigDecimal;

public interface TransactionService {

    Account saveBalance(Double balance, Account account);

    BigDecimal getBalance(Long accountNumber);

    Account addBalance(BigDecimal changeBalance, Long accountNumber) throws UnableToFindAccountException;

    Account deductBalance(BigDecimal changeBalance, Long accountNumber) throws UnableToFindAccountException;

}
