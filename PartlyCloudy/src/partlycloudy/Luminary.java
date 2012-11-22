
package partlycloudy;

import java.util.Random;

/*
 * Chernov Dmitriy
 * 271 group
 */

public class Luminary implements ILuminary
{
    private Random generator = new Random();
    @Override
    public boolean isShining() 
    {
        boolean isshiny = generator.nextBoolean();
        return isshiny;
    }
}
