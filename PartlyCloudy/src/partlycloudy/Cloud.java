
package partlycloudy;

import javax.naming.OperationNotSupportedException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/*
 * Chernov Dmitriy
 * 271 group
 */

public class Cloud
{
    private IDaylight daylight ;
    private ILuminary luminary ;
    private IWind wind ;
    private IMagic magic ;
    
    public Cloud (IDaylight d, ILuminary l, IWind w, IMagic m)
    {
        daylight = d;
        luminary = l;
        wind = w;
        magic = m;
    }

    private Creature internalCreate()
    {
        DaylightType d = daylight.current();
        Boolean l = luminary.isShining();
        int wp = wind.getPower();
        if (d == DaylightType.NIGHT)
        {
            if (!l)
            {
                return new Creature(CreatureType.BAT);
            }
            else
            {
                return new Creature(CreatureType.MOUSEKIN);
            }
        }
        if (d == DaylightType.NOON)
        {
            if (wp <= 5)
            {
                return new Creature(CreatureType.BEARCUB);
            }
            else
            {
                return new Creature(CreatureType.HEDGEHOG);
            }
        }
        if (d == DaylightType.AFTERNOON)
        {
            if (wp <8 && l)
            {
                return new Creature(CreatureType.PIGLET);
            }
            else 
            {
                return new Creature(CreatureType.PUPPY);
            }
        }
        if (d == DaylightType.MORNING)
        {
            if (l)
            {
                return new Creature(CreatureType.KITTEN);
            }
            else 
            {
                return new Creature(CreatureType.TIGERCUB);
            }
        }
        
      throw new NotImplementedException();
    }
    
    public Creature create() //throws OperationNotSupportedException
    {
        Creature creature = internalCreate();
        
            switch (creature.getCreatureType()) 
            {
                case PUPPY:
                case PIGLET:
                case KITTEN:
                case BEARCUB:
                    magic.callStork(creature.getCreatureType());
                    break;
                case MOUSEKIN:
                case HEDGEHOG:
                case BAT: 
                case TIGERCUB:
                    magic.callDaemon(creature.getCreatureType());
                    break;
                //default:
                    //throw new OperationNotSupportedException("Unknown creature!");
            }
        return creature;
    }
}