package exp.avishek.bankapplication.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class Customer extends Person implements Serializable {
    private Long id;
    private SSN ssnValue;
    private Account accountInfo;
    private List<Document> documents;
    private Boolean accountStatus;

    public Customer(String firstName, String lastName, Gender gender, Long id, SSN ssnValue, Account accountInfo, List<Document> documents, Boolean accountStatus) {
        super(firstName, lastName, gender);
        this.id = id;
        this.ssnValue = ssnValue;
        this.accountInfo = accountInfo;
        this.documents = documents;
        this.accountStatus = accountStatus;
    }
}
