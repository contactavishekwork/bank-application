package exp.avishek.bankapplication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private Gender gender;

}
