package exp.avishek.bankapplication.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customer", schema = "random_bank", catalog = "")
public class CustomerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "ssn_value")
    private int ssnValue;
    @Basic
    @Column(name = "account_id")
    private long accountId;
    @Basic
    @Column(name = "account_status")
    private byte accountStatus;
    @Basic
    @Column(name = "gerder")
    private String gerder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSsnValue() {
        return ssnValue;
    }

    public void setSsnValue(int ssnValue) {
        this.ssnValue = ssnValue;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public byte getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(byte accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getGerder() {
        return gerder;
    }

    public void setGerder(String gerder) {
        this.gerder = gerder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id && ssnValue == that.ssnValue && accountId == that.accountId && accountStatus == that.accountStatus && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(gerder, that.gerder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, ssnValue, accountId, accountStatus, gerder);
    }
}
