package interpreter;

import interpreter.TreeNodes.*;
import interpreter.TreeNodes.Number;

public abstract class Interpreter 
{    
    public Expression substitute(Expression expr, String id, Expression body) 
    {
        switch (expr.getType()) 
        {
            case OP: 
                Op op = (Op)expr;
                op.setLeft(substitute(op.getLeft(), id, body));        
                op.setRight(substitute(op.getRight(), id, body));
                return op;
            case FUNDEF:
                FunDef f = (FunDef)expr;
                if (!f.getId().equals(id)) 
                {
                    f.setBody(substitute(f.getBody(), id, body));
                }
                return f;
            case LET: 
                Let l = (Let)expr;
                if (!l.getId().equals(id)) 
                {
                    l.setBound(substitute(l.getBound(), id, body));
                    l.setExpr(substitute(l.getExpr(), id, body));
                }
                return l;
            case IDENTIFIER: 
                Identifier i = (Identifier)expr;
                if (id.equals(i.getName())) 
                {
                    return (Expression)body.deepcopy();
                }    
                return i;
            case FUNCALL: 
                FunCall c = (FunCall)expr;
                c.setFun(substitute(c.getFun(), id, body));
                c.setArg(substitute(c.getArg(), id, body));
                return c;
            case NUMBER: 
                return expr;
        }
        return null;
    }
    
    private Expression eval(Op op) throws Exception 
    {
        Expression l = eval(op.getLeft());
        Expression r = eval(op.getRight());
        
        if (l.getType() != ExprType.NUMBER || r.getType() != ExprType.NUMBER) 
        {
            throw new Exception();
        }
        
        Number left = (Number)l;
        Number right = (Number)r;
        
        switch (op.getOp()) 
        {
            case ADD: return new Number(left.getVal() + right.getVal());
            case SUB: return new Number(left.getVal() - right.getVal());
            case MULT: return new Number(left.getVal() * right.getVal());
            case DIV: 
                if (right.getVal() == 0) 
                {
                    throw new Exception();
                }
                else
                {
                    return new Number(left.getVal()/right.getVal());
                }
        }
        return null;
    }
    
    private Expression eval(FunDef fun) throws Exception 
    {
        return fun;
    }
    
    private Expression eval(Identifier id) throws Exception 
    {
        throw new Exception();
    }
    
    private Expression eval(Number numb) 
    {
        return numb;
    }
    
    public Expression eval(Expression expr) throws Exception 
    {
        switch (expr.getType()) 
        {
            case OP: 
                return eval((Op)expr);
            case FUNDEF: 
                return eval((FunDef)expr);
            case LET: 
                return eval((Let)expr);
            case IDENTIFIER: 
                return eval((Identifier)expr);
            case FUNCALL: 
                return eval((FunCall)expr);
            case NUMBER: 
                return eval((Number)expr);
            default:
                throw new Exception();
        }
    }
    
    abstract Expression eval(FunCall funcll) throws Exception;
    abstract Expression eval(Let let) throws Exception;
}
