package hashtable;
	
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTable 
{
    private int size;
    private List<List<TableElem>> table = new ArrayList<>();
    
    public HashTable(int size) 
    {
        this.size=size;
        for (int i = 0; i < size; i++) 
        {
            table.add(new ArrayList<TableElem>());
        }
    }
    
    //djb2 & sdbm hash functions
    private int hashfunc (String s)
    {  
        long hash = 0;
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            hash = s.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }
        return Integer.parseInt(Long.toString(Math.abs(hash % size)));
    }
    
    public void put(String key, Object data) 
    {
        if (key != null) 
        {
            int hash = hashfunc(key); 
            List<TableElem> list;
            list = table.get(hash);
            list.add(new TableElem(key, data));
        }
    }

    public TableElem get(String key) 
    {
        if (key != null) 
        {
           key = key.toLowerCase();
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
           key = key.toLowerCase();
           int hash = hashfunc(key);
           if(table.get(hash).isEmpty())
           {
               return false;
           }
           else
           {
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
    
    public void showStatistic()
    {
        int min = Integer.MAX_VALUE, max = 0, numwords = 0, n = 0;
        double stand_dev = 0.0f, avdev = 0.0f;
        List<Integer> dev = new ArrayList<>(size);
        for(List<TableElem> list : table) 
        {
            for(TableElem elem : list) 
            {
                n ++;
            }
            numwords += n;
            dev.add(n);
            if (n > max) 
            {
                max = n;
            }
            if (n < min) 
            {
                min = n;
            }
            n = 0;
        }
        for(Integer i : dev) 
        {
            avdev += i - numwords/size; 
            stand_dev += (i - numwords/size)^2;
        }
        stand_dev = (double) Math.sqrt(stand_dev/size);
        System.out.println("number of words: " + Integer.toString(numwords));
        System.out.println("min:" + Integer.toString(min));
        System.out.println("max:" + Integer.toString(max));
        System.out.println("average:" + Float.toString(numwords/size));
        System.out.println("average dev:" + Double.toString(avdev/size));
        System.out.println("standart dev:" + Double.toString(stand_dev));
    }
}