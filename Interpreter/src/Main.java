
/*
 * Chernov Dmitriy
 * 271 group
 */

import interpreter.*;
import interpreter.TreeNodes.*;
import interpreter.parser.*;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Parser pr = new Parser();
        Expression n = pr.parse("let x = 1 in x + 3 + 1");
        Interpreter i = new NormalInterpreter();
        Expression e = i.eval((Expression)n);
        System.out.println(e.toString());
    }
}