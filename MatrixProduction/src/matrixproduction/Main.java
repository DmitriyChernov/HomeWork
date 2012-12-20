/*
 * Chernov Dmitriy
 * 271 group
 */
package MatrixProduction;

import matrixproduction.MatrixProduct;


public class Main {

    public static void main(String[] args) throws IllegalArgumentException
    {
        int [][]a = {{1,2,3},
                     {4,5,6},
                     {7,8,9}
                    };
        int [][]b = {{1,2},
                     {4,5},
                     {7,8}
                    };
        MatrixProduct mm = new MatrixProduct();
        int [][]res = mm.MatrixProduction(a, b);
        for(int []m : res) 
        {
            for(int i = 0; i < m.length; i++) 
            {
                System.out.print(m[i]+" ");
            }
            System.out.println();
        }
    }
}
