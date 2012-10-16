/*
 *Chernov Dmitriy
 * 271 group
 */

package palindrome;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {   
        Scanner sc = new Scanner(System.in);
        String s = ""; Palindrome p;
        p = new CaseInsensetivePalindrome();
        if (sc.hasNext())
        {
            s = sc.next();
        }
        System.out.println(p.isPalindrome(s));
    }
}

