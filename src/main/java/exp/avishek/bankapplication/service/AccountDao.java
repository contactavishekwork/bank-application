package exp.avishek.bankapplication.service;

import exp.avishek.bankapplication.model.Account;

import java.util.List;

public interface AccountDao {

    Account getAccountDataByNumber(Long accountNumber);

    List<Account> getAccountsByUserName(String username);
}
