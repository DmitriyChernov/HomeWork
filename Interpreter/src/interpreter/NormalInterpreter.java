package interpreter;

import interpreter.TreeNodes.*;


public class NormalInterpreter extends Interpreter
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
        Expression res = eval(substitute(fun.getBody(), fun.getId(), eval(funcll.getArg())));
        return res;
    }

    @Override
    Expression eval(Let let) throws Exception 
    {
        return eval(substitute(let.getExpr(),let.getId(), eval(let.getBound())));
    }
}