/*
 * Chernov Dmitriy
 * 271 group
 */

package partlycloudy;

import org.jmock.Expectations;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jmock.Mockery;

public class CloudTest 
{
    
    private Mockery context = new Mockery();
    final IDaylight dl = context.mock(IDaylight.class);
    final IWind w = context.mock(IWind.class);
    final ILuminary l = context.mock(ILuminary.class);
    final IMagic m = context.mock(IMagic.class);

    public CloudTest() 
    {
    }
    
    @Test
    public void PuppyCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.AFTERNOON), new TestLuminary(false), 
                                   new TestWind(9), new Magic());
        CreatureType expResult = CreatureType.PUPPY;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void KittenCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.MORNING), new TestLuminary(true), 
                                   new TestWind(1), new Magic());
        CreatureType expResult = CreatureType.KITTEN;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void MousekinCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.NIGHT), new TestLuminary(true), 
                                   new TestWind(1), new Magic());
        CreatureType expResult = CreatureType.MOUSEKIN;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void BatCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.NIGHT), new TestLuminary(false), 
                                   new TestWind(1), new Magic());
        CreatureType expResult = CreatureType.BAT;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void BearcubCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.NOON), new TestLuminary(true), 
                                   new TestWind(1), new Magic());
        CreatureType expResult = CreatureType.BEARCUB;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void HedgehogCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.NOON), new TestLuminary(true), 
                                   new TestWind(7), new Magic());
        CreatureType expResult = CreatureType.HEDGEHOG;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void PigletCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.AFTERNOON), new TestLuminary(true), 
                                   new TestWind(1), new Magic());
        CreatureType expResult = CreatureType.PIGLET;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void TigercubCreate() 
    {
        System.out.println("create");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.MORNING), new TestLuminary(false), 
                                   new TestWind(1), new Magic());
        CreatureType expResult = CreatureType.TIGERCUB;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void PuppyDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.AFTERNOON));
            one(w).getPower();  will(returnValue(9));
            one(l).isShining(); will(returnValue(false));
            one(m).callStork(CreatureType.PUPPY);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
    
    @Test
    public void MousekinDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.NIGHT));
            one(w).getPower();  will(returnValue(9));
            one(l).isShining(); will(returnValue(true));
            one(m).callDaemon(CreatureType.MOUSEKIN);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
    
    @Test
    public void BatDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.NIGHT));
            one(w).getPower();  will(returnValue(9));
            one(l).isShining(); will(returnValue(false));
            one(m).callDaemon(CreatureType.BAT);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
    
    @Test
    public void KittenDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.MORNING));
            one(w).getPower();  will(returnValue(9));
            one(l).isShining(); will(returnValue(true));
            one(m).callStork(CreatureType.KITTEN);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
    
    @Test
    public void TigercubDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.MORNING));
            one(w).getPower();  will(returnValue(9));
            one(l).isShining(); will(returnValue(false));
            one(m).callDaemon(CreatureType.TIGERCUB);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
    
    @Test
    public void PigletDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.AFTERNOON));
            one(w).getPower();  will(returnValue(1));
            one(l).isShining(); will(returnValue(true));
            one(m).callStork(CreatureType.PIGLET);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
    
    @Test
    public void HedgehogDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.NOON));
            one(w).getPower();  will(returnValue(9));
            one(l).isShining(); will(returnValue(false));
            one(m).callDaemon(CreatureType.HEDGEHOG);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
    
    @Test
    public void BearcubDynamicCreateTest() 
    {    
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations() 
        {{
            one(dl).current();  will(returnValue(DaylightType.NOON));
            one(w).getPower();  will(returnValue(1));
            one(l).isShining(); will(returnValue(false));
            one(m).callStork(CreatureType.BEARCUB);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();   
    }
}


