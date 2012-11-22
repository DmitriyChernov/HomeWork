/*
 * Chernov Dmitriy
 * 271 group
 */
package partlycloudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args)
    {   
        Cloud c = new Cloud(new Daylight(), new Luminary(), 
                                   new Wind(), new Magic());
        
        System.out.println(c.create().getCreatureType());
    }
}