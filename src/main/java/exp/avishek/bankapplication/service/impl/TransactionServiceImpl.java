package exp.avishek.bankapplication.service.impl;

import exp.avishek.bankapplication.dao.AccountDao;
import exp.avishek.bankapplication.dao.TransactionDao;
import exp.avishek.bankapplication.exceptions.UnableToFindAccountException;
import exp.avishek.bankapplication.model.Account;
import exp.avishek.bankapplication.model.entity.AccountMainEntity;
import exp.avishek.bankapplication.service.TransactionService;
import exp.avishek.bankapplication.util.mapper.AccountMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class is responsible for managing the different transaction methods.
 * The transaction operations that will be present in this class are:
 * * Save Balance
 * * Get Balance
 * * Add to existing balance to facilitate deposits
 * * Subtract from existing balance to facilitate withdrawal
 *
 * @author avidatta1 (Avishek Datta)
 */
@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDao transactionDao;

    private final AccountDao accountDao;

    public TransactionServiceImpl(TransactionDao transactionDao, AccountDao accountDao) {
        this.transactionDao = transactionDao;
        this.accountDao = accountDao;
    }

    /**
     * @param changeBalance is the amount which is to be saved.
     * @param account       contains the accountNumber where the balance will be saved
     * @return Account object with the updated balance
     */
    @Override
    public Account saveBalance(Double changeBalance, Account account) {
        AccountMainEntity accountMain = accountDao.getAccountMainEntitiesByAccountNumber(account.getAccountNumber());
        accountMain.setAccountBalance(changeBalance);

        try {
            synchronized (transactionDao) {
                accountMain = transactionDao.save(accountMain);
            }
        }catch (Exception exception) {
            exception.printStackTrace();
        }

        return AccountMapper.toAccount(accountMain);
    }

    /**
     * This method only returns the existing balance from the account object
     * @param accountNumber contains the account number of the customer
     * @return Account Object containing the complete information of the customer
     */
    @Override
    public BigDecimal getBalance(Long accountNumber) {
        BigDecimal balance = BigDecimal.ZERO;
        AccountMainEntity accountMain;

        try {
            accountMain = accountDao.getAccountMainEntitiesByAccountNumber(accountNumber);
            balance = BigDecimal.valueOf(accountMain.getAccountBalance());
            balance = balance.setScale(2, RoundingMode.CEILING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    /**
     * @param changeBalance
     * @param accountNumber
     * @return
     */
    @Override
    public Account addBalance(BigDecimal changeBalance, Long accountNumber) throws UnableToFindAccountException {

        AccountMainEntity accountMain = null;

        try{
            accountMain = accountDao.getAccountMainEntitiesByAccountNumber(accountNumber);

            if(accountMain == null) {
                throw new UnableToFindAccountException(Long.toString(accountNumber));
            }

            BigDecimal newBalance = BigDecimal.valueOf(accountMain.getAccountBalance()).add(changeBalance);
            newBalance = newBalance.setScale(2, RoundingMode.CEILING);
            accountMain.setAccountBalance(Double.parseDouble(newBalance.toPlainString()));
            synchronized (transactionDao) {
                accountMain = transactionDao.save(accountMain);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        assert accountMain != null;
        return AccountMapper.toAccount(accountMain);
    }

    /**
     * @param changeBalance
     * @param accountNumber
     * @return
     */
    @Override
    public Account deductBalance(BigDecimal changeBalance, Long accountNumber) throws UnableToFindAccountException {

        AccountMainEntity accountMain = null;

        try{
            accountMain = accountDao.getAccountMainEntitiesByAccountNumber(accountNumber);

            if(accountMain == null) {
                throw new UnableToFindAccountException(Long.toString(accountNumber));
            }

            BigDecimal newBalance = BigDecimal.valueOf(accountMain.getAccountBalance()).subtract(changeBalance);
            newBalance = newBalance.setScale(2, RoundingMode.CEILING);
            accountMain.setAccountBalance(Double.parseDouble(newBalance.toPlainString()));
            synchronized (transactionDao) {
                accountMain = transactionDao.save(accountMain);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        assert accountMain != null;
        return AccountMapper.toAccount(accountMain);
    }
}
