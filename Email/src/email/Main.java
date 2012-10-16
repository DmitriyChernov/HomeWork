/*
 * Chernov Dmitriy
 * 271 group
 */

package email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        String s;
        Email rez;
        rez= new Email();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        s=sc.readLine();
        if (rez.isEmail(s))
        {
            System.out.println("Its e-mail");
        }
        else
        {
            System.out.println("This is not e-mail");
        }
    }   
}
