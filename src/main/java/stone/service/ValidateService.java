package stone.service;

import stone.exception.dontCorrectArgumentRuntimeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateService {
    private static Pattern pattern;
    private static Matcher matcher;

    public static void validate(String parameter,String regexTemplate) {
        pattern = Pattern.compile(regexTemplate);
        matcher = pattern.matcher(parameter);
        if (!matcher.matches()) {
            throw new dontCorrectArgumentRuntimeException("The received data does not match the specified pattern\n");
        }
    }


    public static void notNull(Object o) {
        if (o == null) {
            throw new dontCorrectArgumentRuntimeException("dont correct argument");

        }
    }

}
