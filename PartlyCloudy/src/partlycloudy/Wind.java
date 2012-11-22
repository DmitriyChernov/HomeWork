
package partlycloudy;

import java.util.Random;

/*
 * Chernov Dmitriy
 * 271 group
 */

public class Wind implements IWind
{
    private Random generator = new Random();
    @Override
    public int getPower()
    {
        int power = generator.nextInt(10);
        return power;
    }
}
