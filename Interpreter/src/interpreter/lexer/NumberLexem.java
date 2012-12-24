/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.lexer;

public class NumberLexem  extends Lexem
{
    private int value;
    
    public NumberLexem(int value)
    {
        super(LexemType.NUMBER);
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
}
