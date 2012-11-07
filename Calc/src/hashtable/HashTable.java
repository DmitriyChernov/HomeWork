package hashtable;
	
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTable 
{
    private int size;
    private List<List<TableElem>> table = new ArrayList<>();
    
    public HashTable(int _size) 
    {
        size = _size;
        for (int i = 0; i < size; i++) 
        {
            table.add(new ArrayList<TableElem>());
        }
    }
    //sdbm hash function
    private int hashfunc (String s)
    {
        long hash = 0;
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            hash = i + (hash << 6) + (hash << 16) - hash;
        }
        return Integer.parseInt(Long.toString(Math.abs(hash % size)));
    }
    
    public void put(String key, int elem) 
    {
        if (key != null) 
        {
           int hash = hashfunc(key); 
           List<TableElem> list;
           list = table.get(hash);
           list.add(new TableElem(key, elem));
        }
    }

    public TableElem get(String key) 
    {
        if (key != null) 
        {
           int hash = hashfunc(key); 
           List<TableElem> list;
           list = table.get(hash);
           if (list.isEmpty()) 
           {
               return null;
           } 
           else 
           {
               for(TableElem elem : list) 
               {
                    if (key.equals(elem.key)) 
                    {
                        return elem;
                    }
                }
           }

        }
        return null;
    }
    
    public void delete(String key) 
    {
        if (key != null) 
        {
           int hash = hashfunc(key); 
           List<TableElem> list;
           list = table.get(hash);
           if (!list.isEmpty()) 
           {
               Iterator iter = list.iterator(); 
               TableElem elem;
               while(iter.hasNext()) 
               {
                    elem = (TableElem)iter.next();
                    if (key.equals(elem.key)) 
                    {
                        iter.remove();
                        return;
                    }
                }
           }
        }
    }
            
    public boolean isInTable (String key)
    {
       if (key != null)
       {
           int hash = hashfunc(key);
           if(table.get(hash).isEmpty())
           {
               return false;
           }
           else{
              List<TableElem> list = table.get(hash); 
              for(TableElem elem:list)
              {
                  if (key.equals(elem.key)) 
                  {
                        return true;
                  }
              }
              return false;
           }
       }
       return false;
    }
}