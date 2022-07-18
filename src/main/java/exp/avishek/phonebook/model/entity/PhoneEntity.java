package exp.avishek.phonebook.model.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "phone", schema = "phonebook", catalog = "")
public class PhoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "phone_id")
    private int phoneId;
    @Basic
    @Column(name = "country_code")
    private String countryCode;
    @Basic
    @Column(name = "home_phone")
    private String homePhone;
    @Basic
    @Column(name = "office_phone")
    private String officePhone;
    @Basic
    @Column(name = "cell_phone")
    private String cellPhone;

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PhoneEntity that = (PhoneEntity) o;

        return new EqualsBuilder().append(phoneId, that.phoneId).append(countryCode, that.countryCode).append(homePhone, that.homePhone).append(officePhone, that.officePhone).append(cellPhone, that.cellPhone).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(phoneId).append(countryCode).append(homePhone).append(officePhone).append(cellPhone).toHashCode();
    }
}
