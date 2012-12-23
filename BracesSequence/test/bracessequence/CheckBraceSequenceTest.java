/*
 * Chernov Dmitriy
 * 271 group
 */
package bracessequence;

import org.junit.Test;
import static org.junit.Assert.*;

public class CheckBraceSequenceTest {
    
    public CheckBraceSequenceTest() 
    {
    }
    
    @Test
    public void NullStr() 
    {
       System.out.println("EmptyStr");
       String seq = null;
       CheckBraceSequence instance = new CheckBraceSequence(seq);
       boolean expResult = false;
       boolean result = instance.isCorrect();
       assertEquals(expResult, result);
    }
    @Test
    public void EmptyStr() 
    {
       System.out.println("EmptyStr");
       String seq = "";
       CheckBraceSequence instance = new CheckBraceSequence(seq);
       boolean expResult = true;
       boolean result = instance.isCorrect();
       assertEquals(expResult, result);
    }
    @Test
    public void NotXMLtest() 
    {
       System.out.println("EmptyStr");
       String seq = "([])";
       CheckBraceSequence instance = new CheckBraceSequence(seq);
       boolean expResult = true;
       boolean result = instance.isCorrect();
       assertEquals(expResult, result);
    }
    @Test
     public void XMLtest() 
     {
        System.out.println("EmptyStr");
        String seq = "<a awdawdawd> () </a>";
        CheckBraceSequence instance = new CheckBraceSequence(seq);
        boolean expResult = true;
        boolean result = instance.isCorrect();
        assertEquals(expResult, result);
    }
}
