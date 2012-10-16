/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.security.InvalidParameterException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class PascalTriangleTest {
    
    public PascalTriangleTest() 
    {
    }
    
    @Test
    public void simpleTest() 
    {
        System.out.println("Combination");
        int x = 1;
        int y = 1;
        int expResult = 2;
        int result = PascalTriangle.Combination(x, y);
        assertEquals(expResult, result);
    }
    
    @Test
    public void zeroTest() 
    {
        System.out.println("Combination2");
        int x = 0;
        int y = 0;
        int expResult = 1;
        int result = PascalTriangle.Combination(x, y);
        assertEquals(expResult, result);
    }
    
    @Test(expected = InvalidParameterException.class)
    public void NegPoint() throws InvalidParameterException {
        System.out.println("Combination3");
        int x = -1;
        int y = 0;
        PascalTriangle.Combination(x, y);
    }
}
