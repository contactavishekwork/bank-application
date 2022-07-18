package exp.avishek.bankapplication.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class Validator {

    public Boolean isSSNValid(String ssnValue) {
        Boolean flag = Boolean.FALSE;

        Pattern p = Pattern.compile(Constants.SSN_PATTERN);

        // If the string is empty
        // return false
        if (ssnValue == null)
        {
            return false;
        }

        // Pattern class contains matcher()
        //  method to find matching between
        //  given string and regular expression.
        Matcher m = p.matcher(ssnValue);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }
}
