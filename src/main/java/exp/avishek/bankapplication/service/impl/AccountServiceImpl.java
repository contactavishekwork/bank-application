package exp.avishek.bankapplication.service.impl;

import exp.avishek.bankapplication.dao.UserDao;
import exp.avishek.bankapplication.model.Account;
import exp.avishek.bankapplication.model.entity.AccountMainEntity;
import exp.avishek.bankapplication.model.entity.UserEntity;
import exp.avishek.bankapplication.service.AccountDao;
import exp.avishek.bankapplication.util.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for getting any and all data related to the account of a customer.
 * The account Information includes:
 * * Account Number
 * * Username / Password (Login Information)
 * * Type of account: Savings / Checking
 * * Account Balance
 * * Account Creation Date
 * * Account Update Date
 *
 * TODO: Phase 2 will include file reading for Documents. Encrypt / Decrypt Password.
 *
 * @author avidatta1 (Avishek Datta)
 *
 */
@Service
public class AccountServiceImpl implements AccountDao {

    private final UserDao userDao;
    private final exp.avishek.bankapplication.dao.AccountDao accountDao;

    public AccountServiceImpl(UserDao userDao, exp.avishek.bankapplication.dao.AccountDao accountDao) {
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    /**
     * @param accountNumber is the account number for a customer. The service re-maps the entity class
     *                      to the model and returns the Account Details to the Controller.
     * @return the account details of the user.
     */
    @Override
    public Account getAccountDataByNumber(Long accountNumber) {

        AccountMainEntity accountMainEntity = accountDao.getAccountMainEntitiesByAccountNumber(accountNumber);
        UserEntity userEntity = userDao.getUserById(accountMainEntity.getUserId());

        Account account = AccountMapper.toAccount(accountMainEntity);
        account.setUserInfo(AccountMapper.toUser(userEntity));

        return account;
    }

    /**
     * @param username is the username passed as a search criteria. It is assumed that the username is
     *                 not unique to an account. Searching with the username returns a list of the
     *                 accounts associated with that username.
     * @return a list of the Accounts associated with the username
     */
    @Override
    public List<Account> getAccountsByUserName(String username) {

        List<UserEntity> users = userDao.getAllByUsernameMatches(username);

        return users.stream()
                .map(
                    account -> AccountMapper.toAccount(
                            accountDao.getAccountMainEntitiesByAccountNumber((long) account.getAccountId())))
                .collect(Collectors.toList());

    }
}
