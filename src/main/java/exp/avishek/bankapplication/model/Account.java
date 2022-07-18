package exp.avishek.bankapplication.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.sql.Date;


public class Account {
    private Long accountNumber;
    private User userInfo;
    private AccountType accountType;
    private Double accountBalance;
    private Date accountCreatedDate;
    private Date accountUpdateDate;

    public Account(Long accountNumber, User userInfo, AccountType accountType, Double accountBalance, Date accountCreatedDate, Date accountUpdateDate) {
        this.accountNumber = accountNumber;
        this.userInfo = userInfo;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.accountCreatedDate = accountCreatedDate;
        this.accountUpdateDate = accountUpdateDate;
    }

    public Account() {

    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public Date getAccountUpdateDate() {
        return accountUpdateDate;
    }

    public void setAccountUpdateDate(Date accountUpdateDate) {
        this.accountUpdateDate = accountUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;


        return new EqualsBuilder().append(accountNumber, account.accountNumber).append(userInfo, account.userInfo).append(accountType, account.accountType).append(accountBalance, account.accountBalance).append(accountCreatedDate, account.accountCreatedDate).append(accountUpdateDate, account.accountUpdateDate).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(accountNumber).append(userInfo).append(accountType).append(accountBalance).append(accountCreatedDate).append(accountUpdateDate).toHashCode();
    }
}
