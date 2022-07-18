package exp.avishek.bankapplication.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformation {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Long phone1;
    private Long phone2;
    private Long cellPhone;
    private EmergencyContact emergencyContact;

}
