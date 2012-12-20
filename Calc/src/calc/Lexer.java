/*
 * Chernov Dmitriy
 * 271 group
 */

package calc;

public class Lexer 
{
    LexemType curlexem;
    int pos=0;
    String line;
    int value;
    String var;
    
    public Lexer(String line)
    {
        this.line = line;
    }
    
    public void resetPos()
    {
        pos = 0;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public String getName()
    {
        return var;
    }
    
    public LexemType getlexem() throws Exception
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
            curlexem = LexemType.EOL;
            return curlexem;       
        }
        char c = line.charAt(pos);
      
	switch (c)
	{
		case '+':
		{	
                    curlexem = LexemType.PLUS;
                    pos++;
                    break;
		}
		case '-':
		{		
                    curlexem = LexemType.MINUS;
                    pos++;
                    break;
		}
		case '*':
		{	
                    curlexem = LexemType.MULT;
                    pos++;
                    break;
		}
		case '/':
		{		
                    curlexem = LexemType.DIV;
                    pos++;
                    break;
		}
		case '(':
		{	
                    curlexem = LexemType.OBRACE;
                    pos++;
                    break;
		}
		case ')':
		{	
                    curlexem = LexemType.CBRACE;
                    pos++;
                    break;
		}
                case '=':
                {
                    curlexem = LexemType.EQ;
                    pos++;
                    break;        
                }
		default:
		{
		   if (Character.isDigit(c)) 
                   {
                        String numb = "";
                        try 
                        {
                            while (Character.isDigit(c)) 
                            {
                                numb += c;
                                pos++;
                                c = line.charAt(pos);
                            }
                        } 
                        catch(StringIndexOutOfBoundsException e) 
                        {}
                        try 
                        {
                            value = Integer.parseInt(numb);
                            curlexem = LexemType.NUM;
                        } 
                        catch(NumberFormatException e) 
                        {
                            throw new Exception();
                        }
                    }
                   else if (Character.isLetter(c)) 
                   {
                        String variable = "";
                        try 
                        {
                            while (Character.isLetter(c)) 
                            {
                                variable += c;
                                pos++;
                                c = line.charAt(pos);
                            }
                        } 
                        catch(StringIndexOutOfBoundsException e) 
                        {}
                        try 
                        {
                            var = variable;
                            curlexem = LexemType.VAR;
                        } 
                        catch(NumberFormatException e) 
                        {
                            throw new Exception();
                        }
                   }
                   else 
                   {
                       throw new Exception();
                   }
                }
        }
        return curlexem;
    }
    
    public LexemType getfuturelexem() throws Exception
    {
        LexemType c = curlexem;
        int i = pos;
        int n = value;
        String v = var;
        getlexem();
        LexemType next = curlexem;
        curlexem = c;
        pos = i;
        value = n;
        var = v;
        return next;
    }
}
