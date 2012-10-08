
package squaring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static squaring.SquareCore.SquareCore.*;

public class Squaring 
{
    public static void main(String[] args) throws IOException 
    {
        int n,rez;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine());
        rez=SquaringNumber(n);
        System.out.println(rez);
    }
}
