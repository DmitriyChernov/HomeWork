/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

import java.util.Observable;

public class Controller extends Observable
{          
    public void getResult(String unit, String value) 
    {
        this.setChanged();
        if (unit.equals("Celsius"))
        {
            this.notifyObservers(new FieldsPackage(TempType.CEL, Integer.valueOf(value)));
        }
        if (unit.equals("Kelvin"))
        {
            this.notifyObservers(new FieldsPackage(TempType.KEL, Integer.valueOf(value)));
        }
        else
        {
            this.notifyObservers(new FieldsPackage(TempType.FAR, Integer.valueOf(value)));
        }     
    }   
}
