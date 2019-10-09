package stone.utility;

public final class RegexTemplate {

    public static final String REGEX_FOR_NAME = "[A-Za-z]{2,200}";
    public static final String REGEX_FOR_PHONE_NUMBER = "[0-9]{10,13}";
    public static final String REGEX_FOR_PASSWORD = "[A-Za-z0-9]{10,32}";
    public static final String REGEX_FOR_EMAIL =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";



    private RegexTemplate() {
    }



}
