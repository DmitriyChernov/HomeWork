package bracessequence;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckBraceSequence 
{
    private Stack stack = new Stack();
    private String line;
    private int pos = 0;
    public CheckBraceSequence(String s)
    {
        line = s;
    }
    
    public boolean isCorrect()
    {
        Object n;
        int length = line.length();
        String xml="";
        String cxml="";
        while (pos < length)
        {
            if (line.charAt(pos) == '(' || line.charAt(pos) == '[')
            {
                stack.push(line.charAt(pos));
            }
            if (line.charAt(pos) == '<' && line.charAt(pos+1) != '/')
            {
                while (line.charAt(pos) != '>')
                {
                    if (Character.isLetterOrDigit(line.charAt(pos)))
                    {
                        xml = xml + line.charAt(pos);
                    }
                    pos++;
                }
                stack.push(xml);
                xml = "";
            }
            switch (line.charAt(pos))
            {
                case ')':
                    if(stack.isEmpty())
                    {
                        return false;
                    }
                    n =  stack.pop();
                    if (!n.equals('('))
                    {
                        return false;
                    } 
                    break;
                case ']' :
                    if(stack.isEmpty())
                    {
                        return false;
                    }
                    n =  stack.pop();
                    if (!n.equals('['))
                    {
                        return false;
                    }
                    break;
                case '<':
                    if (line.charAt(pos+1) == '/')
                    {
                        if(stack.isEmpty())
                        {
                            return false;
                        }

                        pos++;
                        while (line.charAt(pos) != '>')
                        {
                            if (Character.isLetterOrDigit(line.charAt(pos)))
                            {
                                cxml = cxml + line.charAt(pos);
                            }
                            pos++;
                        }           
                        n = stack.pop();
                        if (!n.equals(cxml))
                        {
                            return false;
                        }
                    }
                    else 
                    {
                        return false;
                    }
                    break;   
            }
            pos ++;
        }
        if (stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}