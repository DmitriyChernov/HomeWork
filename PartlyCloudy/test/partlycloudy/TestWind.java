
package partlycloudy;

import java.util.Random;
import partlycloudy.IWind;

/*
 * Chernov Dmitriy
 * 271 group
 */

public class TestWind implements IWind
{
    private int p;
    
    public TestWind (int p)
    {
        this.p=p;
    }
    
    @Override
    public int getPower()
    {
        return p;
    }
}