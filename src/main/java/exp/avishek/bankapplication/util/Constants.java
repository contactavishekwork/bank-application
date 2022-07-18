package exp.avishek.bankapplication.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final String SSN_PATTERN = "^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";
}
