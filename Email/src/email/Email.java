/*
 * Chernov Dmitriy
 * 271 group
 */

package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email
{
    public static boolean isEmail(String email)
    {
        Pattern p = Pattern.compile("^[a-zA-Z!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+(?:[A-Za-z]{2,3}|info|mobi|name|aero|jobs|museum)$");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        return b;
    }
}
