/*Chernov Dmitriy
 * 271 group
 */
package robot;

import java.security.InvalidParameterException;

public class PascalTriangle
{
    public static int Combination(int x, int y) throws InvalidParameterException
    {
        if (x<0 || y<0) throw new InvalidParameterException ("Координаты положительны!");
        FactorialUtil fact;
        fact = new FactorialUtil();
        if (x>y)
        {
            int temp=x;
            x=y;
            y=temp;
        }
        x=x+y;
        return fact.factorial(x)/(fact.factorial(y)*fact.factorial(x-y));      
    }
}
