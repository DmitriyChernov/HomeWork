/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.TreeNodes;

public class Identifier extends Expression 
{
    private String name;
    
    public Identifier(String name) 
    {
        this.name = name;
        type = ExprType.IDENTIFIER;
    }
    
    public String getName() 
    {
        return name;
    } 

    @Override
    public Object deepcopy() 
    {
        return new Identifier(name);
    }
}
