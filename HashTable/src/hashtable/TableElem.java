/*
 * Chernov Dmitriy
 * 271 group
 */
package hashtable;

public class TableElem 
{
    protected String key;
    protected Object data;
    public TableElem (String key, Object data) 
    {
        this.key=key; this.data=data;
    }
    public String getKey() 
    {
        return key;
    }
    public Object getData() 
    {
        return data;
    } 
    public void setData(Object d) 
    {
        data = d;
    }
}