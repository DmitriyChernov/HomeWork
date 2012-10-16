package coins;

import static org.junit.Assert.*;
import org.junit.Test;

public class CombinationsTest {
    
    public CombinationsTest() {
    }

    @Test
    public void zeroSum() 
    {
        System.out.println("Combinations");
        int n = 0;
        int []c = {1,5,10,25,50};
        Combinations instance = new Combinations(c);
        int expResult = 1;
        int result = instance.numberCombinations(0, n, c);
        assertEquals(expResult, result);
    }
   @Test(expected = IllegalArgumentException.class)
    public void NegPoint() throws IllegalArgumentException {
        System.out.println("Combinations");
        int n = 10;
        int []c = null;
        Combinations instance = new Combinations(c);
        instance.numberCombinations(0, n, c);
    }
    @Test
    public void simpleCombination() 
    {
        System.out.println("Combinations");
        int n = 5;
        int []c = {1,5,10,25,50};
        Combinations instance = new Combinations(c);
        int expResult = 2;
        int result = instance.numberCombinations(0, n, c);
        assertEquals(expResult, result);
    }
}
