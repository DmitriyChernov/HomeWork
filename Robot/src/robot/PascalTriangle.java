package robot;
public class PascalTriangle
{
    public static int Combination(int x, int y)
    {
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
