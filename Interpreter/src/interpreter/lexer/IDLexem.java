/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.lexer;

public class IDLexem  extends Lexem
{
    private String name;
    
    public IDLexem(String name)
    {
        super(LexemType.ID);
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}
