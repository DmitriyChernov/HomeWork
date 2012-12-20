/*
 * Chernov Dmitriy
 * 271 group
 */
package matrixproduction;

import java.util.concurrent.Callable;

public class ProductMatrixThread implements Callable<int[]>
{
    private int[]a;
    private int[][]b;
    public ProductMatrixThread (int[] line, int[][] matrix)
    {
        a=line;
        b=matrix;
    }
 
    @Override
    public int[] call() throws Exception 
    {
        int length=a.length;
        int heigth=b[0].length;
        int i,j,rez;
        int[] rezLine=new int[heigth]; 
        for (i=0;i<heigth;i++)
        {
            rez=0;
            for (j=0;j<length;j++) 
            {
                rez+=a[j]*b[j][i];
            }
            rezLine[i]=rez;
        }
        return rezLine;
    }

}
