/*
 * Chernov Dmitriy
 * 271 group
 */
package palindrome;

import java.security.InvalidParameterException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author user
 */
public class CaseInsensetivePalindromeTest 
{    
    public CaseInsensetivePalindromeTest() 
    {
    }
    @Test
    public void emptyPalindrome() 
    {
        System.out.println("isPalindrome");
        String s = "";
        CaseInsensetivePalindrome instance = new CaseInsensetivePalindrome();
        boolean expResult = true;
        boolean result = instance.isPalindrome(s);
        assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void NegPoint() throws IllegalArgumentException {
        System.out.println("isPalindrome2");
        String s = null;
        CaseInsensetivePalindrome instance = new CaseInsensetivePalindrome();
        boolean result = instance.isPalindrome(s);
    }
    @Test
    public void notLetOrDigitPalindrome() 
    {
        System.out.println("isPalindrome3");
        String s = "!?";
        CaseInsensetivePalindrome instance = new CaseInsensetivePalindrome();
        boolean expResult = true;
        boolean result = instance.isPalindrome(s);
        assertEquals(expResult, result);
    }
    @Test
    public void SimplePalindrome() 
    {
        System.out.println("isPalindrome4");
        String s = "I prefer Pi!";
        CaseInsensetivePalindrome instance = new CaseInsensetivePalindrome();
        boolean expResult = true;
        boolean result = instance.isPalindrome(s);
        assertEquals(expResult, result);
    }
}
