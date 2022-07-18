package exp.avishek.bankapplication.service;

import exp.avishek.bankapplication.model.Account;

public interface TransactionService {

    Account saveBalance(Double balance, Account account);

    Account getBalance(Long accountNumber);

    Account addBalance(Long changeBalance, Long accountNumber);

    Account deductBalance(Long changeBalance, Long accountNumber);

}
