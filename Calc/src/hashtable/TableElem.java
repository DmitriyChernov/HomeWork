/*
 * Chernov Dmitriy
 * 271 group
 */
package hashtable;

public class TableElem 
{
    protected String key;
    protected int value;
    public TableElem (String k, int v) 
    {
        key = k; value = v;
    }
    public String getStr() 
    {
        return key;
    }
    public int getValue() 
    {
        return value;
    } 
}