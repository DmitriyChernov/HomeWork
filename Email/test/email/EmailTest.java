/*
 * Chernov Dmitriy
 * 271 group
 */

package email;

import static org.junit.Assert.*;
import org.junit.Test;

public class EmailTest 
{
    
    public EmailTest() 
    {
    }
    @Test
    public void validEmail1() 
    {
        System.out.println("Valid email");
        String s = "a@b.cc";
        Email instance = new Email();
        boolean expResult = true;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void validEmail2() 
    {
        System.out.println("Valid email");
        String s = "victor.polozov@mail.ru";
        Email instance = new Email();
        boolean expResult = true;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void validEmail3() 
    {
        System.out.println("Valid email");
        String s = "_.1@mail.com";
        Email instance = new Email();
        boolean expResult = true;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void validEmail4() 
    {
        System.out.println("Valid email");
        String s = "my@domain.info";
        Email instance = new Email();
        boolean expResult = true;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void validEmail5() 
    {
        System.out.println("Valid email");
        String s = "coins@hermitage.museum";
        Email instance = new Email();
        boolean expResult = true;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void invalidEmail1() 
    {
        System.out.println("Invalid email");
        String s = "a@b.c";
        Email instance = new Email();
        boolean expResult = false;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void invalidEmail2() 
    {
        System.out.println("Invalid email");
        String s = "a..b@mail.ru";
        Email instance = new Email();
        boolean expResult = false;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void invalidEmail3() 
    {
        System.out.println("Invalid email");
        String s = ".a@mail.ru";
        Email instance = new Email();
        boolean expResult = false;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void invalidEmail4() 
    {
        System.out.println("Invalid email");
        String s = "yo@domain.domain";
        Email instance = new Email();
        boolean expResult = false;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
    @Test
    public void invalidEmail5() 
    {
        System.out.println("Invalid email");
        String s = "1@mail.ru";
        Email instance = new Email();
        boolean expResult = false;
        boolean result = instance.isEmail(s);
        assertEquals(expResult, result);
    }
}
