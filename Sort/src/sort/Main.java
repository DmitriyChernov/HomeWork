/*
 * Chernov Dmitriy
 * 271 group
 */
package sort;

public class Main 
{
    public static void main(String[] args) 
    {
        Integer []m = {6,7,9,5,3,4,1,0};
        UniBubbleSort us = new UniBubbleSort();
        IntCompare MyCompare = new IntCompare();
        us.sort(m, MyCompare);
        for(int i = 0; i < 8; i++) 
        {
            System.out.print(m[i] + " ");
        }
    }
}
