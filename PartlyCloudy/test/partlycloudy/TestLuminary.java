
package partlycloudy;

import java.util.Random;
import partlycloudy.ILuminary;

/*
 * Chernov Dmitriy
 * 271 group
 */

public class TestLuminary implements ILuminary
{
    private boolean l;
    
    public TestLuminary(boolean l)
    {
        this.l = l;
    }
    @Override
    public boolean isShining() 
    {
        return l;
    }
}