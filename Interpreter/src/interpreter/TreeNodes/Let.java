/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.TreeNodes;

public class Let extends Expression 
{
    private String id;
    private Expression bound;
    private Expression expr;
    
    public Let(String id, Expression bound, Expression expr) 
    {
        this.bound = bound;
        this.expr = expr;
        this.id = id;
        type = ExprType.LET;
    }
    
    public String getId() 
    {
        return id;
    }
    
    public Expression getBound() 
    {
        return bound;
    }
    
    public Expression getExpr() 
    {
        return expr;
    }
    
    public void setBound(Expression b) 
    {
        bound = b;
    }
    
    public void setExpr(Expression e) 
    {
        expr = e;
    }

    @Override
    public Object deepcopy() {
        
        return new Let(id,(Expression)bound.deepcopy(),(Expression)expr.deepcopy());
    }
}