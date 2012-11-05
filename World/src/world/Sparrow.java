
package world;

import java.util.Random;

public class Sparrow extends Bird
{
    protected birdEmotion emotion = birdEmotion.Neutral;
    @Override
    public String getReaction (String opponent) 
    {
        String reaction = "Спокойствие";
        StoryTeller author = new StoryTeller();
        switch (opponent) {
            case "Кошка":
                Cat cat = new Cat();
                reaction="Убежать";
                emotion=birdEmotion.Scared;
                author.TellStory("Воробей напуган. Он в спешке убегает от кошки");
                cat.getReaction("Sparrow");
                break;
            case "Собака":
                reaction="Осмотреть";
                emotion=birdEmotion.Interested;
                author.TellStory("Воробей заинтересован собакой. Как же она к нему отнесется?");
                Random randomGenerator = new Random();
                boolean dogLoveBirds = randomGenerator.nextBoolean();
                if (dogLoveBirds)
                {
                    author.TellStory("Воробей обрадован встречей с дружелюбной собакой");
                    emotion=Bird.birdEmotion.Happy;
                }
                else
                {
                    author.TellStory("Воробей напуган голодной собакой. Он в спешке убегает от собаки");
                    emotion=Bird.birdEmotion.Scared;
                }
                break;
        }
        return reaction;
    }
}