/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.TreeNodes;

public abstract class Expression
{
    protected ExprType type;
    
    public ExprType getType() 
    {
        return type;
    }
    
    abstract public Object deepcopy();
}
