/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.lexer;

public class Lexem 
{
    private LexemType type;
    
    public Lexem (LexemType type) 
    {
        this.type = type;
    }
    
    public LexemType getType() 
    {  
        return type;
    }
}
