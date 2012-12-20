/*
 * Chernov Dmitriy
 * 271 group
 */
package hashtable;

public class TableElem <T>
{
    protected String key;
    protected T data;
    public TableElem (String key, T data) 
    {
        this.key=key; this.data=data;
    }
    public String getKey() 
    {
        return key;
    }
    public T getData() 
    {
        return data;
    } 
    public void setData(T d) 
    {
        data = d;
    }
}