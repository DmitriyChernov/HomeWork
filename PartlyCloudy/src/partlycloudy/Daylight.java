
package partlycloudy;

import java.util.Random;

/*
 * Chernov Dmitriy
 * 271 group
 */

public class Daylight implements IDaylight
{
    private Random generator = new Random();
    @Override
    public DaylightType current() 
    {
        int roll = generator.nextInt(3);
        switch (roll)
        {
            case 0:
                    return DaylightType.MORNING;
            case 1:
                    return DaylightType.NOON;
            case 2:
                    return DaylightType.AFTERNOON;
            default:
                    return DaylightType.NIGHT;
        }                   
    }
    
}
