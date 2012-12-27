/*
 * Chernov Dmitriy
 * 271 group
 */
package interpreter.parser;

import interpreter.TreeNodes.*;
import interpreter.TreeNodes.Number;
import interpreter.lexer.*;

public class Parser 
{

    private Lexer lexer = new Lexer();
    
    private Expression expr() throws Exception
    {
        switch(lexer.curlexem().getType())
        {
            case LET: 
                return let();
            case FUN: 
                return funCall();
            default: 
                return binOp();
        }
    }
    
    private Expression funCall() throws Exception 
    {
        lexer.nextlexem();
        if (lexer.curlexem().getType() != LexemType.ID) 
        {
            throw new Exception();
        }
        String id = ((IDLexem) lexer.curlexem()).getName();
        lexer.nextlexem();
        if (lexer.curlexem().getType() != LexemType.ARROW) 
        {
            throw new Exception();
        }
        lexer.nextlexem();
        return new FunDef(id, (Expression) expr());
    }

    private Expression let() throws Exception 
    {
        lexer.nextlexem();
        if (lexer.curlexem().getType() != LexemType.ID) 
        {
            throw new Exception();
        }
        String id = ((IDLexem) lexer.curlexem()).getName();
        lexer.nextlexem();
        if (lexer.curlexem().getType() != LexemType.ASSIGN) 
        {
            throw new Exception();
        }
        lexer.nextlexem();
        Expression bound = (Expression) expr();
        if (lexer.curlexem().getType() != LexemType.IN) 
        {
            throw new Exception();
        }
        lexer.nextlexem();
        Expression expr = (Expression) expr();
        return new Let(id, bound, expr);
    }

    private Expression binOp() throws Exception 
    {
        Expression left = term();
        LexemType l = lexer.curlexem().getType();
        if (l == LexemType.PLUS) 
        {
            lexer.nextlexem();
            return new Op(OpType.ADD, (Expression) left, (Expression) binOp());
        }
        if (l == LexemType.MINUS) 
        {
            lexer.nextlexem();
            return new Op(OpType.SUB, (Expression) left, (Expression) binOp());
        }
        return left;
    }
    
    private Expression term() throws Exception 
    {
        Expression left = factor();
        LexemType l = lexer.curlexem().getType();
        if (l == LexemType.MULT) 
        {
            lexer.nextlexem();
            return new Op(OpType.MULT, (Expression) left, (Expression) term());
        }
        if (l == LexemType.DIV) 
        {
            lexer.nextlexem();
            return new Op(OpType.DIV, (Expression) left, (Expression) term());
        }
        return left;
    }

    private Expression factor() throws Exception
    {
        return funcall();
    }
    
    private Expression funcall() throws Exception 
    {
        Expression n = primary();
        while(lexer.curlexem().getType() == LexemType.ID ||
              lexer.curlexem().getType() == LexemType.OBR ||
              lexer.curlexem().getType() == LexemType.NUMBER) 
        {
            n = new FunCall((Expression)n, (Expression)primary());
        }
        return n;
    }
    
    private Expression primary() throws Exception
    {
        switch(lexer.curlexem().getType())
        {
            case NUMBER: 
                int val = ((NumberLexem)lexer.curlexem()).getValue();
                lexer.nextlexem();
                return new Number(val);

            case ID: 
                String id = ((IDLexem)lexer.curlexem()).getName();
                lexer.nextlexem();
                return new Identifier(id);
            
            case OBR: 
                lexer.nextlexem();
                Expression n = expr();
                if(lexer.curlexem().getType() != LexemType.CBR)
                {
                    throw new Exception();
                }
                lexer.nextlexem();
                return n; 
            default:
                throw new Exception();
        }
    }
    
    public Expression parse(String text) throws Exception 
     {
        lexer.doLexemArray(text);
        Expression res = this.expr();
        lexer.nextlexem();
        if (lexer.curlexem().getType() != LexemType.EOL) 
        {
            throw new Exception();
        }
        return res;
    }
}
