
package partlycloudy;

/*
 * Chernov Dmitriy
 * 271 group
 */

public class TestDaylight implements IDaylight
{
    private DaylightType d;
    
    public TestDaylight (DaylightType d)
    {
        this.d = d;
    }
    
    @Override
    public DaylightType current() 
    {
        return d;
    }
}