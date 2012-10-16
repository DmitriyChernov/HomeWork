/*Chernov Dmitriy
 * 271 group
 */
package robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        int x,y;
        PascalTriangle rez;
        rez= new PascalTriangle();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        x=Integer.parseInt(sc.readLine());
        y=Integer.parseInt(sc.readLine());
        System.out.println(rez.Combination(x,y));
    }   
}