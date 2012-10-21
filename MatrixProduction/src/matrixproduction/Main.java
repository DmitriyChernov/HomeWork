/*
 * Chernov Dmitriy
 * 271 group
 */
package MatrixProduction;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import matrixproduction.ProductMatrixThread;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException
    {
        int [][]a = {{1,2,3},{4,5,6},{7,8,9}};
        int [][]b = {{1,2,3},{4,5,6},{7,8,9}};
        int resMatrix[][];
        int heigth1=a.length;
        int heigth2=b.length;
        int length1=a[0].length;
        int length2=b[0].length;
        int i;
        if (a==null || b==null)
        {
            System.out.println("Матрицы не инициализированы!");
            throw new IllegalArgumentException();
        }
        for (i=1; i<heigth1; i++)
        {
            if (a[i].length!=length1)
            {
                System.out.println("Строки первой матрицы не равны по длине!");
                throw new IllegalArgumentException();
            }
        }
        for (i=1; i<heigth2; i++)
        {
            if (b[i].length!=length1)
            {
                System.out.println("Строки второй матрицы не равны по длине!");
                throw new IllegalArgumentException();
            }
        }
        if (heigth2!=length1)
        {
            System.out.println("Строки второй матрицы не равны по длине с высотой второй матрицы!");
            throw new IllegalArgumentException();
        }
        
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<int[]>> res = new ArrayList<>();
        int k = -1; int [][] r = new int[heigth1][length2];
        for(i=0; i < heigth1; i++) 
        {
            ProductMatrixThread ProdThread = new ProductMatrixThread(a[i], b);
            res.add(exec.submit(ProdThread));
        }
        for(Future<int[]> f : res) 
        {
            try 
            {
                k++;
                r[k] = f.get();
            } 
            catch (InterruptedException | ExecutionException e) 
            {} 
            finally 
            {
                exec.shutdown();
            }
        }
    }
}
