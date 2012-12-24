/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.TreeNodes;

public abstract class Expression extends Node 
{
    protected ExprType type;
    
    public ExprType getType() 
    {
        return type;
    }
}
