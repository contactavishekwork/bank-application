package exp.avishek.bankapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Document {

    private String documentName;
    private String documentPath;
    private Date validityEndDate;
}
