/*
 * Chernov Dmitriy
 * 271 group
 */

import java.io.BufferedReader;
import java.io.FileReader;
import hashtable.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextInHashTable 
{
    int size = 500;
    int NumWords = 0;
    HashTable ht = new HashTable (size);
    
    public void put(String key) 
    {
        if (key != null) 
        {
            key = key.toLowerCase();
            if (ht.isInTable(key))
            {
                TableElem e = ht.get(key);
                e.setData((int)e.getData() + 1);
            }
            else 
            {
                ht.put(key, 1);
            }
            ++ NumWords;
        }
    }
    
    public int get(String s) 
    {
        if (s == null) 
        {
            return 0;
        } 
        else 
        {
            s = s.toLowerCase();
            TableElem elem = ht.get(s);  
            if (elem != null) 
            {
                return (int)elem.getData();
            }        
            return 0;
        }
    }
    
    public void readFromFile(String filename) 
    {
        try (BufferedReader f = new BufferedReader(new FileReader(filename))) 
        {
            int c = f.read(); 
            String key = "";
            while(c != -1) 
            {
                while(Character.isLetter(c) || Character.isDigit(c) || c=='-') 
                {
                    key += Character.toString((char)c).toLowerCase();
                    c = f.read();
                } 
                c = f.read();
                if (!"".equals(key)) 
                {
                    put(key); 
                    key = "";
                }
            }
            f.close();
            ht.showStatistic();
            System.out.println("Words number:  " + NumWords);
        }      
        catch(FileNotFoundException e)
        {
             System.out.println("File" + filename + " not found");
        }
        catch(IOException e)
        {
             System.out.println("Cant read from " + filename);
        }
    }
}
