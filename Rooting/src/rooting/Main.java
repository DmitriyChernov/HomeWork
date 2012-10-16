/*Chernov Dmitriy
 * 271 group
 */
package rooting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        Double n,eps;
        Rooting rez;
        rez= new Rooting();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        n=Double.parseDouble(sc.readLine());
        eps=0.001*n;
        System.out.println(rez.sqrtGeron(n,eps));
    }   
}
