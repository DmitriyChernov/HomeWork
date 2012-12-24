/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Controller 
{
    private JComboBox unit; 
    private JTextField temp; 
    private FieldChanger fc;
    
    public Controller(JComboBox unit, JTextField temp, FieldChanger fc)
    {
        this.unit = unit;
        this.temp = temp;
        this.fc = fc;
    }
    
            
    public void getResult() 
    {
        String item = (String)unit.getSelectedItem();
        int value = Integer.valueOf(temp.getText());
        String  cel = "";
        String  kel = "";
        String  far = "";
        if ("Celsius".equals(item))
        {
            cel = Integer.toString(value);
            kel = Integer.toString(value + 273);
            far = Long.toString(Math.round(value * 9/5 + 32));
        }
        if ("Kelvin".equals(item))
        {
            cel = Integer.toString(value - 273);
            kel = Integer.toString(value);
            far = Long.toString(Math.round(value * 9/5 - 459));
        }
        if ("Fahrenheit".equals(item))
        {
            cel = Long.toString(Math.round(value - 32)*5/9);
            kel = Long.toString(Math.round((value + 459.67)*5/9));
            far = Integer.toString(value);
        }
        fc.changeFields(cel, kel, far);
    }   
}
