
package world;

public class Cat extends Mammal
{
    @Override
    public String Animal (String opponent) 
    {
        String reaction = "Спокойствие";
        if ("Собака".equals(opponent))
        {
            reaction="Шипение";
        }
        else if ("Воробей".equals(opponent))
        {
            reaction="Попытка скушать";
        }
        return reaction;
    }
}
