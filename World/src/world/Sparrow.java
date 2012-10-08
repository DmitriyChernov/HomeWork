
package world;

import java.util.Random;

public class Sparrow extends Bird
{
    protected birdEmotion emotion = birdEmotion.Neutral;
    @Override
    public String getReaction (String opponent) 
    {
        String reaction = "Спокойствие";
        switch (opponent) {
            case "Кошка":
                reaction="Убежать";
                emotion=birdEmotion.Scared;
                System.out.println("Воробей напуган. Он в спешке убегает от кошки");
                Cat cat = new Cat();
                cat.getReaction("Sparrow");
                break;
            case "Собака":
                reaction="Осмотреть";
                emotion=birdEmotion.Interested;
                System.out.println("Воробей заинтересован собакой. Как же она к нему отнесется?");
                Random randomGenerator = new Random();
                boolean dogLoveBirds = randomGenerator.nextBoolean();
                if (dogLoveBirds)
                {
                    emotion=Bird.birdEmotion.Happy;
                    System.out.println("Воробей обрадован встречей с дружелюбной собакой");
                }
                else
                {
                    System.out.println("Воробей напуган голодной собакой. Он в спешке убегает от собаки");
                    emotion=Bird.birdEmotion.Scared;
                }
                break;
        }
        return reaction;
    }
}