/*
 * Chernov Dmitriy
 * 271 group
 */

import java.io.IOException;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        String filename = "Invisible_Monsters.txt";
        TextInHashTable text = new TextInHashTable();
        text.readFromFile(filename);
    }
}
