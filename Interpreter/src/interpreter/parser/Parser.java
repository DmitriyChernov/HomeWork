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
    Lexem curlexem;

    
    private Node expr() throws Exception
    {
        switch(curlexem.getType()){
            case LET: 
                return let();
            case FUN: 
                return funCall();
            default: 
                return binOp();
        }
    }
    
    private Node funCall() throws Exception 
    {
        lexer.nextlexem();
        if (curlexem.getType() != LexemType.ID) 
        {
            throw new Exception();
        }
        String id = ((IDLexem) curlexem).getName();
        lexer.nextlexem();
        if (curlexem.getType() != LexemType.ARROW) 
        {
            throw new Exception();
        }
        lexer.nextlexem();
        return new FunDef(id, (Expression) expr());
    }

    private Node let() throws Exception 
    {
        lexer.nextlexem();
        if (curlexem.getType() != LexemType.ID) 
        {
            throw new Exception();
        }
        String id = ((IDLexem) curlexem).getName();
        lexer.nextlexem();
        if (curlexem.getType() != LexemType.ASSIGN) 
        {
            throw new Exception();
        }
        lexer.nextlexem();
        Expression bound = (Expression) expr();
        if (curlexem.getType() != LexemType.IN) 
        {
            throw new Exception();
        }
        lexer.nextlexem();
        Expression expr = (Expression) expr();
        return new Let(id, bound, expr);
    }

    private Node binOp() throws Exception 
    {
        Node left = term();
        LexemType l = curlexem.getType();
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
    
    private Node term() throws Exception 
    {
        Node left = factor();
        LexemType l = curlexem.getType();
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

    private Node factor() throws Exception
    {
        return funcall();
    }
    
    private Node funcall() throws Exception 
    {
        Node n = primary();
        while(curlexem.getType() == LexemType.ID ||
              curlexem.getType() == LexemType.OBR ||
              curlexem.getType() == LexemType.NUMBER) 
        {
            n = new FunCall((Expression)n, (Expression)primary());
        }
        return n;
    }
    
    private Node primary() throws Exception
    {
        switch(curlexem.getType())
        {
            case NUMBER: 
                int val = ((NumberLexem)curlexem).getValue();
                lexer.nextlexem();
                return new Number(val);

            case ID: 
                String id = ((IDLexem)curlexem).getName();
                lexer.nextlexem();
                return new Identifier(id);
            
            case OBR: 
                lexer.nextlexem();
                Node n = expr();
                if(curlexem.getType() != LexemType.CBR)
                {
                    throw new Exception();
                }
                lexer.nextlexem();
                return n;
                
            default:
                throw new Exception();
        }
    }
}
