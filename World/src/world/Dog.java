
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
        StoryTeller author = new StoryTeller();
        switch (opponent) {
            case "Кошка":
                reaction="Гавканье";
                emotion=mammalEmotion.Agressive;
                boolean fightSuccess = randomGenerator.nextBoolean();
                if (fightSuccess)
                {
                    emotion=mammalEmotion.Happy;
                    author.TellStory("Собака победила кошку. Она празднует победу");
                }
                else
                {
                    emotion=mammalEmotion.Scared;
                    author.TellStory("Собаке нанесли поражение. Она испуганно убегает");
                }
                break;
            case "Воробей":
                Sparrow sparrow = new Sparrow();
                reaction="Обнюхать";
                emotion=mammalEmotion.Interested;            
                author.TellStory("Собака заинтересована птичкой. Чем же ответит воробей?");
                sparrow.getReaction("Dog");
        }
        return reaction;
    }
}
