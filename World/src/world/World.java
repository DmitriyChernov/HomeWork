package world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class World 
{
    public static void main(String[] args) throws IOException 
    { 
        String reaction=null,first=null,second=null;
        Dog dog=new Dog();
        Cat cat=new Cat();
        Sparrow sparrow=new Sparrow();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        first=sc.readLine();
        second=sc.readLine();
        switch (first)
        {
            case "Собака": reaction=dog.Animal(second); break;
            case "Кошка": reaction=cat.Animal(second); break;
            case "Воробей": reaction=sparrow.Animal(second);break;
        }
        System.out.println(reaction);
    }
}
