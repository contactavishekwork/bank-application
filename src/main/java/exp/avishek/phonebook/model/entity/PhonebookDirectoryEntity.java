package exp.avishek.phonebook.model.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "phonebook_directory", schema = "phonebook")
public class PhonebookDirectoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pb_id")
    private int pbId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "ssn")
    private String ssn;
    @Basic
    @Column(name = "phone_id")
    private int phoneId;
    @Basic
    @Column(name = "c_address_id")
    private Integer cAddressId;
    @Basic
    @Column(name = "p_address_id")
    private int pAddressId;

    public int getPbId() {
        return pbId;
    }

    public void setPbId(int pbId) {
        this.pbId = pbId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PhonebookDirectoryEntity that = (PhonebookDirectoryEntity) o;

        return new EqualsBuilder().append(pbId, that.pbId).append(phoneId, that.phoneId).append(firstName, that.firstName).append(lastName, that.lastName).append(age, that.age).append(ssn, that.ssn).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(pbId).append(firstName).append(lastName).append(age).append(ssn).append(phoneId).toHashCode();
    }

    public Integer getcAddressId() {
        return cAddressId;
    }

    public void setcAddressId(Integer cAddressId) {
        this.cAddressId = cAddressId;
    }

    public int getpAddressId() {
        return pAddressId;
    }

    public void setpAddressId(int pAddressId) {
        this.pAddressId = pAddressId;
    }
}
