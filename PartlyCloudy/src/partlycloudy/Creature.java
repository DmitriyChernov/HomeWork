/*
 * Chernov Dmitriy
 * 271 group
 */

package partlycloudy;


public class Creature 
{
    private CreatureType ct;
    
    public Creature(CreatureType ct) 
    {
        this.ct = ct;
    }
    public CreatureType getCreatureType() 
    {
        return ct;
    }
}