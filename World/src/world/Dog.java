
package world;

public class Dog extends Mammal
{
    @Override
    public String Animal (String opponent) 
    {
        String reaction = "Спокойствие";
        if ("Кошка".equals(opponent))
        {
            reaction="Гавканье";
        }
        else if ("Воробей".equals(opponent))
        {
            reaction="Обнюхать";
        }
        return reaction;
    }
}
