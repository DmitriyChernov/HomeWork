
package world;

public class Sparrow extends Mammal
{
    @Override
    public String Animal (String opponent) 
    {
        String reaction = "Спокойствие";
        if ("Кошка".equals(opponent))
        {
            reaction="Убежать";
        }
        else if ("Собака".equals(opponent))
        {
            reaction="Осмотреть";
        }
        return reaction;
    }
}