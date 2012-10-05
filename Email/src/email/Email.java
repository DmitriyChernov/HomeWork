package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email
{
    public static boolean isEmail(String email)
    {
        Pattern p = Pattern.compile("([a-zA-Z][\\w]*)@([a-zA-Z][\\w]*[.])*([a-zA-Z][\\w]*[.][a-zA-Z]{2,3})");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        return b;
    }
}
