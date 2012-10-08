
package world;

import java.util.Random;

public class Dog extends Mammal
{
    protected mammalEmotion emotion = mammalEmotion.Neutral;
    @Override
    public String getReaction(String opponent) 
    {
        Random randomGenerator = new Random();
        String reaction = "Спокойствие";
        switch (opponent) {
            case "Кошка":
                reaction="Гавканье";
                emotion=mammalEmotion.Agressive;
                boolean fightSuccess = randomGenerator.nextBoolean();
                if (fightSuccess)
                {
                    emotion=mammalEmotion.Happy;
                    System.out.println("Собака победила кошку. Она празднует победу");
                }
                else
                {
                    emotion=mammalEmotion.Scared;
                    System.out.println("Собаке нанесли поражение. Она испуганно убегает");
                }
                break;
            case "Воробей":
                reaction="Обнюхать";
                emotion=mammalEmotion.Interested;
                System.out.println("Собака заинтересована птичкой. Чем же ответит воробей?");
                Sparrow sparrow = new Sparrow();
                sparrow.getReaction("Dog");
        }
        return reaction;
    }
}
