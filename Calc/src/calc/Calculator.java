/*
 * Chernov Dmitriy
 * 271 group
 */
package calc;

import hashtable.*;

public class Calculator 
{
    LexemType curlexem;
    int pos=0;
    String line;
    int value;
    String var;
    HashTable ht = new HashTable (500);
    
    public int assign(String s)
    {
        line=s;
        pos=0;
        getlexem();
        if(getfuturelexem() == LexemType.EQ)
        {
            getlexem();
            int res = expr();
            if (curlexem != LexemType.NOTHING)
            {
                curlexem=LexemType.ERR;
            }
            ht.put(var, (int) res);
            return res;
        }
        else
        {
            pos=0;
            int res = expr();
            return res;
        }   	
    }
    
    public int expr()
    {
       	int op1=term();
        LexemType action = curlexem;
	while (curlexem==LexemType.PLUS || curlexem==LexemType.MINUS)
	{
		int op2=term();
		if (action==LexemType.PLUS)
		{
			op1=op1+op2;
		}
		else if (action==LexemType.MINUS) 
		{
			op1=op1-op2;
		}
	}
	return op1;
    }
    
    private int term ()
    {
	int op1=factor();
        LexemType action = curlexem;
	while (curlexem==LexemType.MULT || curlexem==LexemType.DIV)
	{
		int op2=factor();
		if (action==LexemType.MULT)
		{
			op1=op1*op2;
		}
		else if (action==LexemType.DIV)
		{
			op1=op1/op2;
		}
	}
	return op1;
    }

    private int factor()
    {
        getlexem();
	if (curlexem==LexemType.NUM)
	{
		int res=value;
		getlexem();
		return res;
	}
        else if(curlexem==LexemType.OBRACE)
		{
			int res=expr();
			if (curlexem!=LexemType.CBRACE)
			{
				curlexem=LexemType.ERR;
			}
			getlexem();
			return res;
		}
                else if (curlexem==LexemType.NOTHING)
                {
                    return 1;
                } 
        else if(curlexem == LexemType.VAR)
        {
            if(!ht.isInTable(var))
            {
                 curlexem=LexemType.ERR;
            }
             int res = (int) ht.get(var).getValue();
             getlexem();
             return res;
        }
        return 0;
    }
        
    private void getlexem()
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
            curlexem = LexemType.NOTHING;
            return ;
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
                            curlexem = LexemType.ERR;
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
                            curlexem = LexemType.ERR;
                        }
                   }
                   else 
                   {
                       curlexem = LexemType.ERR;
                   }
                }
        }
    }
    
    public LexemType getfuturelexem()
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
