package exp.avishek.bankapplication.service.impl;

import exp.avishek.bankapplication.dao.AccountDao;
import exp.avishek.bankapplication.dao.TransactionDao;
import exp.avishek.bankapplication.model.Account;
import exp.avishek.bankapplication.model.entity.AccountMainEntity;
import exp.avishek.bankapplication.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao;

    private AccountDao accountDao;

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
            transactionDao.save(accountMain);
        }catch (Exception exception) {
            exception.printStackTrace();
        }



        return null;
    }

    /**
     * @param accountBalance
     * @return
     */
    @Override
    public Account getBalance(Long accountBalance) {
        return null;
    }

    /**
     * @param changeBalance
     * @param accountNumber
     * @return
     */
    @Override
    public Account addBalance(Long changeBalance, Long accountNumber) {
        return null;
    }

    /**
     * @param changeBalance
     * @param accountNumber
     * @return
     */
    @Override
    public Account deductBalance(Long changeBalance, Long accountNumber) {
        return null;
    }
}
