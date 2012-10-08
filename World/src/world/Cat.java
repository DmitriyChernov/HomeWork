
package world;

import java.util.Random;

public class Cat extends Mammal
{
    protected mammalEmotion emotion = mammalEmotion.Neutral;
    protected Creature Cat = Creature.Cat;
    @Override
    public String getReaction (String opponent)
    {
        String reaction = "Спокойствие";
        switch (opponent) {
            case "Собака":
                reaction="Шипение";
                emotion=mammalEmotion.Agressive;
                System.out.println("Кошка агрессивно настроена и шипит чтобы отпугнуть собаку");
                Dog dog = new Dog();
                dog.getReaction("Cat");
                break;
            case "Воробей":
                reaction="Атака";
                emotion=mammalEmotion.Agressive;
                System.out.println("Кошка агрессивно настроена и хочет сцапать воробья");
                Random randomGenerator = new Random();
                boolean success = randomGenerator.nextBoolean();
                if (success)
                {
                    emotion=mammalEmotion.Fed;
                    System.out.println("Кошка поймала воробья и сьела. Она сыта");
                }
                else
                {
                    emotion=mammalEmotion.Hungry;
                    System.out.println("Кошка не поймала воробья. Она огорчена и голодна");
                }
                break;
        }
        return reaction;
    }
}
