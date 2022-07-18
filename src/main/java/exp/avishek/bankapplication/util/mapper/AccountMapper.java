package exp.avishek.bankapplication.util.mapper;

import exp.avishek.bankapplication.model.Account;
import exp.avishek.bankapplication.model.AccountType;
import exp.avishek.bankapplication.model.User;
import exp.avishek.bankapplication.model.entity.AccountMainEntity;
import exp.avishek.bankapplication.model.entity.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    public Account toAccount(AccountMainEntity accountEntity) {
        Account account = new Account();

        account.setAccountNumber(accountEntity.getAccountNumber());
        account.setAccountType(AccountType.valueOf(accountEntity.getAccountType()));
        account.setAccountBalance(accountEntity.getAccountBalance());
        account.setAccountCreatedDate(accountEntity.getCreateDate());
        account.setAccountUpdateDate(accountEntity.getUpdateDate());
        return account;
    }

    public User toUser(UserEntity userEntity) {
        User user = new User();

        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());

        return user;
    }
}
