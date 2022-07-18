package exp.avishek.bankapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class EmergencyContact extends ContactInformation {

    private String name;
    private String relation;

}
