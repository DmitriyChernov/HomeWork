/*
 * Chernov Dmitriy
 * 271 group
 */
package hashtable;

public class TableElem 
{
    protected String key;
    protected int count;
    public TableElem (String k, int c) 
    {
        key = k; count = c;
    }
    public String getStr() 
    {
        return key;
    }
    public int getValue() 
    {
        return count;
    } 
}