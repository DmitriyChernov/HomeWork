/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.lexer;

import java.util.ArrayList;

public class Lexer 
{
    private int pos=0;
    private Lexem[] lexems;
    private int lp=0;
    
    public void parse(String line)
    {
        ArrayList<Lexem> lexems = new ArrayList<>();
        int length = line.length();
        while (pos < length)
        {
            try 
            {
                while(line.charAt(pos) == ' ') 
                {
                    pos++;
                }
        } 
        catch(StringIndexOutOfBoundsException e) 
        {
            return;
        }   
            char sym = line.charAt(pos);
            switch (sym)
            {
                case '+':
                    lexems.add(new PlusLexem());
                    pos++;
                    break;
                case '*':
                    lexems.add(new MultLexem());
                    pos++;
                    break;
                case '/':
                    lexems.add(new DivLexem());
                    pos++;
                    break;  
                case '(':
                    lexems.add(new OBRLexem());
                    pos++;
                    break;
                case ')':
                    lexems.add(new CBRLexem());
                    pos++;
                    break; 
                case '=':
                    lexems.add(new AssignLexem());
                    pos++;
                    break; 
                case '-':
                    if ((pos + 1) < length && line.charAt(pos + 1) == '>') 
                    {
                        lexems.add(new ArrowLexem());
                        pos += 2;
                    } 
                    else 
                    {
                        lexems.add(new MinusLexem());
                    }
                default:
                    if (Character.isDigit(sym)) 
                    {
                        String numb = "";
                        try 
                        {
                            while (Character.isDigit(sym)) 
                            {
                                numb += sym;
                                pos++;
                                sym = line.charAt(pos);
                            }
                        } 
                        catch(StringIndexOutOfBoundsException e) 
                        {}
                        lexems.add(new NumberLexem(Integer.parseInt(numb)));

                    }
                    if (Character.isLetter(sym))
                    {
                        String name = "";
                        try 
                        {
                            while (Character.isLetter(sym)) 
                            {
                                name += sym;
                                pos++;
                                sym = line.charAt(pos);
                            }
                        } 
                        catch(StringIndexOutOfBoundsException e) 
                        {}
                        
                        switch (name) 
                        {
                        case "let":
                            lexems.add(new LetLexem());
                            break;
                        case "in":
                            lexems.add(new INLexem());
                            break;
                        case "fun":
                            lexems.add(new FunLexem());
                            break;
                        default:
                            lexems.add(new IDLexem(name));
                        }
                    break;
                    }
            }
        }
        this.lexems = lexems.toArray(new Lexem[0]);
        this.pos = 0;
    }
    
    public Lexem nextlexem()
    {
        Lexem i = lexems[lp];
        if(lp < pos )
        {
            lp++;
        }
        return i;
    }
}
