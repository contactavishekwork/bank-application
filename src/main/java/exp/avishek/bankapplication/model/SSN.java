package exp.avishek.bankapplication.model;

import exp.avishek.bankapplication.exceptions.InvalidDataException;
import exp.avishek.bankapplication.util.Validator;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
public class SSN {

    private String ssnValue;

    public SSN(String ssnValue) throws InvalidDataException {
        if(Validator.isSSNValid(ssnValue)) {
            this.ssnValue = ssnValue;
        } else {
            throw new InvalidDataException();
        }
    }

    public String getSsnValue() {
        return ssnValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SSN ssn = (SSN) o;

        return new EqualsBuilder().append(ssnValue, ssn.ssnValue).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(ssnValue).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ssnValue", ssnValue)
                .toString();
    }
}
