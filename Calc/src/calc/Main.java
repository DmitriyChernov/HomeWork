/*
 * Chernov Dmitriy
 * 271 group
 */
package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws IOException, Exception 
    {
        int res;
	String line;
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();
        while (true)
        {
            line=sc.readLine();
            System.out.println("Result: " + Integer.toString(calculator.parse(line)));
            if ("exit".equals(line))
            {
                break;
            }
        }
        System.out.println("Finish");
    }
}
