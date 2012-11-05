
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
        StoryTeller author = new StoryTeller();
        switch (opponent) 
        {
            case "Собака":
                Dog dog = new Dog();
                reaction="Шипение";
                emotion=mammalEmotion.Agressive;
                author.TellStory("Кошка агрессивно настроена и шипит чтобы отпугнуть собаку");
                dog.getReaction("Cat");
                break;
            case "Воробей":
                reaction="Атака";
                emotion=mammalEmotion.Agressive;
                author.TellStory("Кошка агрессивно настроена и хочет сцапать воробья");
                Random randomGenerator = new Random();
                boolean dinnerSuccess = randomGenerator.nextBoolean();
                if (dinnerSuccess)
                {
                    emotion=mammalEmotion.Fed;
                    author.TellStory("Кошка поймала воробья и сьела. Она сыта");
                }
                else
                {
                    emotion=mammalEmotion.Hungry;
                    author.TellStory("Кошка не поймала воробья. Она огорчена и голодна");
                }
                break;
        }
        return reaction;
    }
}
