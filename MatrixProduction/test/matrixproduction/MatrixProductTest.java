/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixproduction;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MatrixProductTest {
    
    public MatrixProductTest() {
    }

    /**
     * Test of MatrixProduction method, of class MatrixProduct.
     */
    @Test (expected = NullPointerException.class)
    public void testMultNullMatrix() 
    {
        System.out.println("multNullMatrix");
        int[][] a = null;
        int[][] b = null;
        MatrixProduct instance = new MatrixProduct();
        instance.MatrixProduction(a, b);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMultIncorrectFormatMatrix() 
    {
        System.out.println("multIncorrectFormatMatrix");
        int[][] a = {{1,2,3},
                     {4,6},
                     {7,8,9}
                    };
        int[][] b = {{1,2},
                     {4,5},
                     {7,8}
                    };
        MatrixProduct instance = new MatrixProduct();
        instance.MatrixProduction(a, b);
    }
    
    @Test
    public void testCorrectMatrix() 
    {
        System.out.println("MultCorrectMatrix");
        int [][]a = {{1,2,3},
                     {4,5,6},
                     {7,8,9}
                    };
        int [][]b = {{1,2},
                     {4,5},
                     {7,8}
                    };
        MatrixProduct instance = new MatrixProduct();
        int [][]expResult = {{30,36},
                             {66,81},
                             {102,126}
                            };
        int [][]result = instance.MatrixProduction(a, b);
        
        for (int i = 0; i < result.length; i++) 
        {
            assertArrayEquals(expResult[i], result[i]);
        }
    }
}
