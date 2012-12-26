/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

public class FieldsPackage
{
    private String cel;
    private String kel;
    private String far;
    
    public FieldsPackage(TempType unit, int value)
    {
        if (unit==TempType.CEL)
        {
            cel = Integer.toString(value ) + " cel";
            kel = Integer.toString(value + 273) + " kel";
            far = Long.toString(Math.round(value * 9/5 + 32)) + " fah";
        }
        if (unit==TempType.KEL)
        {
            cel = Integer.toString(value - 273) + " cel";
            kel = Integer.toString(value) + " kel";
            far = Long.toString(Math.round(value * 9/5 - 459)) + " fah";
        }
        if (unit==TempType.FAR)
        {
            cel = Long.toString(Math.round(value - 32)*5/9) + " cel";
            kel = Long.toString(Math.round((value + 459.67)*5/9)) + " kel";
            far = Integer.toString(value) + " fah";
        }
    }
    
    public String getCel()
    {
        return cel;
    }
    
    public String getKel()
    {
        return kel;
    }
    
    public String getFar()
    {
        return far;
    }
}
