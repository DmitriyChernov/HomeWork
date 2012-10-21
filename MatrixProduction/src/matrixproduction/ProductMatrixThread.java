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
        int heigth=b.length;
        int i,j,rez;
        int[] rezLine=new int[length]; 
        for (i=0;i<length;i++)
        {
            rez=0;
            for (j=0;j<heigth;j++) 
            {
                rez+=a[j]*b[i][j];
            }
            rezLine[i]=rez;
        }
        return rezLine;
    }

}
