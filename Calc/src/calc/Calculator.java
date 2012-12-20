/*
 * Chernov Dmitriy
 * 271 group
 */
package calc;

import hashtable.*;

public class Calculator 
{
    LexemType curlexem;
    String line;
    HashTable<Integer> ht = new HashTable (500);
    Lexer lexer;
    
    public int parse(String s) throws Exception
    {
        line = s;
        lexer = new Lexer(line);
        return assign();
    }
    
    public int assign() throws Exception
    {
        lexer.resetPos();
        curlexem=lexer.getlexem();
        if(lexer.getfuturelexem() == LexemType.EQ)
        {
            curlexem=lexer.getlexem();
            int res = expr();
            if (curlexem != LexemType.EOL)
            {
                throw new Exception();
            }
            ht.put(lexer.getName(), (int) res);
            return res;
        }
        else
        {
            lexer.resetPos();
            int res = expr();
            return res;
        }   	
    }
    
    public int expr() throws Exception
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
    
    private int term () throws Exception
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

    private int factor() throws Exception
    {
        curlexem=lexer.getlexem();
	if (curlexem==LexemType.NUM)
	{
		int res=lexer.getValue();
		curlexem=lexer.getlexem();
		return res;
	}
        else if(curlexem==LexemType.OBRACE)
        {
                int res=expr();
                if (curlexem!=LexemType.CBRACE)
                {
                        throw new Exception();
                }
                curlexem=lexer.getlexem();
                return res;
        }
        else if (curlexem==LexemType.EOL)
        {
            return 1;
        } 
        else if(curlexem == LexemType.VAR)
        {
            if(!ht.isInTable(lexer.getName()))
            {
                 throw new Exception();
            }
            int res = (int) ht.get(lexer.getName()).getData();
            curlexem=lexer.getlexem();
            return res;
        }
        throw new Exception();
    }
}
