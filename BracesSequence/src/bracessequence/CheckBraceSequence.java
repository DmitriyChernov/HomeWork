package bracessequence;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckBraceSequence 
{
    private Pattern p;
    private Matcher m;
    private final String opxmlbr = "\\<[a-zA-z]+(([ ]{0,})|([ ]+.+))\\>";
    private final String ocxmlbr ="\\<[a-zA-z]+[ ]{0,}\\/\\>";
    private final String clxmlbr = "\\<\\/[a-zA-z]+\\>";
    private Stack stack = new Stack();
    private ElemType braceType = ElemType.nothing;
    private ElemType tos = ElemType.nothing;
    private boolean isxmlName = false;
    private String braceName;
    private String xmlName = new String();
    
    public boolean testBraces(String text) 
    {
        if (text != null) 
        {
            tos = ElemType.nothing;
            isxmlName = false; 
            xmlName = "";
            return analysis(text);
        }
        else 
        {
            return false; 
        }
    }
    
    private boolean analysis(String text) 
    {
        int len = text.length();
        int i=0;
        for (i=0; i<len; i++)
        {
            if (isOpenBrace(text.charAt(i)))
            {
                stack.push(new StackElem(braceType, braceName));
            }
            if (isxmlName)
            {
                if (text.charAt(i) == '>') 
                {
                    xmlName += '>'; 
                    isxmlName = false;
                    if (!Matching()) 
                    {
                        return false;
                    }
                    xmlName = "";
                } 
                else 
                {
                    xmlName += text.charAt(i);
                }
            }
            if (isCloseBrace(text.charAt(i)))
            {
                if (stack.isEmpty()) 
                {
                    return false;
                } 
                else 
                {
                    StackElem temp = (StackElem) stack.pop();
                    if (temp.type == ElemType.xmlBrace) 
                    {
                        return false;
                    }              
                    if (getPair(temp.name.charAt(0)) != text.charAt(i)) 
                    {
                        return false;
                    }
                }
            }
        }
        return (!stack.isEmpty() || isxmlName) ? false : true;
    }

    private boolean isOpenBrace(char brace) 
    {
        switch(brace)
        {
            case '(': braceType = ElemType.roundBrace; braceName = "("; return true;
            case '[': braceType = ElemType.roundBrace; braceName = "["; return true;
            case '{': braceType = ElemType.roundBrace; braceName = "{"; return true;
            case '<': braceType = ElemType.triangleBrace;
                      braceName += "<";
                      isxmlName=true;
                      return true;
            default: braceType = ElemType.nothing; return false;
        }
    }

    private char getPair(char brace) 
    {
        switch(brace)
        {
            case '(' : return ')';
            case '[' : return ']';
            case '{' : return '}';
        }
        return 0;
    }

    private boolean isCloseBrace(char brace) 
    {
        return (brace=='(' || brace=='{' || brace=='[');
    }

   boolean Matching() {
        return MatchingOBXML() || MatchingEBXML() || MatchingOCBXML();
    }
    boolean MatchingEBXML() 
    {
        p = Pattern.compile(clxmlbr);
        m = p.matcher(xmlName); 
        if (m.matches()) 
        {
           if (stack.isEmpty()) 
           {
               return false;
           }
           StackElem temp = (StackElem) stack.pop();
           if (temp.type != ElemType.xmlBrace) 
           {
               return false;
           } else {
               if (!getName(xmlName).equals(temp.name)) 
               {
                   return false;
               }
           }
           return true;
        } 
        else 
        {
            return false;
        }
                
    }
    boolean MatchingOBXML() {
        p = Pattern.compile(opxmlbr);
        m = p.matcher(xmlName); 
        if (m.matches()) 
        {
            if (!MatchingOCBXML()) 
            {
                    stack.push(new StackElem(ElemType.xmlBrace, getName(xmlName)));
            } 
            return true;
        } 
        else 
        {
            return false;
        }
    }
    boolean MatchingOCBXML() 
    {
        p = Pattern.compile(ocxmlbr);
        m = p.matcher(xmlName); 
        if (!m.matches()) 
        {
            return false;
        }
        return true;
    }
    String getName(String s) 
    {
        String r = ""; int len = s.length(); char c;
        for(int i = 0; i < len; i++) 
        {
            c = s.charAt(i);
            if (c == ' ') 
            {
                break;
            }
            if (c != '<' && c != '>' && c != '/') 
            {
              r += s.charAt(i);
            }
        }
        return r;
    }
}