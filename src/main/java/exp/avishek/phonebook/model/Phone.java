package exp.avishek.phonebook.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Phone implements Serializable {

    private String countryCode;
    private String homePhone;
    private String officePhone;
    private String cellPhone;

    public Phone() {
    }

    public Phone(String countryCode, String homePhone, String officePhone, String cellPhone) {
        this.countryCode = countryCode;
        this.homePhone = homePhone;
        this.officePhone = officePhone;
        this.cellPhone = cellPhone;
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

        Phone phone = (Phone) o;

        return new EqualsBuilder()
                .append(countryCode, phone.countryCode)
                .append(homePhone, phone.homePhone)
                .append(officePhone, phone.officePhone)
                .append(cellPhone, phone.cellPhone)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(countryCode)
                .append(homePhone)
                .append(officePhone)
                .append(cellPhone)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("countryCode", countryCode)
                .append("homePhone", homePhone)
                .append("officePhone", officePhone)
                .append("cellPhone", cellPhone)
                .toString();
    }
}
