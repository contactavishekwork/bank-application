package exp.avishek.bankapplication.model.entity;

import exp.avishek.bankapplication.model.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "account_main", schema = "random_bank")
public class AccountMainEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_number")
    private long accountNumber;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "account_type")
    private String accountType;
    @Basic
    @Column(name = "account_balance")
    private Double accountBalance;
    @Basic
    @Column(name = "create_date")
    private Date createDate;
    @Basic
    @Column(name = "update_date")
    private Date updateDate;

    private User user;

    public AccountMainEntity(long accountNumber, Integer userId, String accountType, Double accountBalance, Date createDate, Date updateDate, User user) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.user = user;
    }

    public AccountMainEntity() {

    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = Double.valueOf(accountBalance);
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMainEntity that = (AccountMainEntity) o;
        return accountNumber == that.accountNumber && Objects.equals(userId, that.userId) && Objects.equals(accountType, that.accountType) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, userId, accountType, accountBalance, createDate, updateDate);
    }
}
