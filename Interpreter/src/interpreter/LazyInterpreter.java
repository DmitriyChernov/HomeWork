/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter;

import interpreter.TreeNodes.*;

public class LazyInterpreter extends Interpreter
{

    @Override
    Expression eval(FunCall funcll) throws Exception
    {
        Expression f = eval(funcll.getFun());
        if (f.getType() != ExprType.FUNDEF) 
        {
            throw new Exception();
        }
        FunDef fun = (FunDef)f;  
        return eval(substitute(fun.getBody(), fun.getId(), funcll.getArg()));
    }

    @Override
    Expression eval(Let let) throws Exception 
    {      
        return eval(substitute(let.getExpr(), let.getId(), let.getBound()));
    }
}