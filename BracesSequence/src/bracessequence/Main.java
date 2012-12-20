package bracessequence;

/*Chernov Dmitriy
 * 271 group
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String s; 
        s = sc.readLine();
        CheckBraceSequence testBraces = new CheckBraceSequence(s);
        System.out.println(testBraces.isCorrect());
    }
}