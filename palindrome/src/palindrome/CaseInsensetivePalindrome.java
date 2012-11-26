/*
 *Chernov Dmitriy
 * 271 group
 */

package palindrome;

public class CaseInsensetivePalindrome extends Palindrome 
{
    @Override
    public boolean compare(char a, char b)
    {
         return (Character.toLowerCase(a) != Character.toLowerCase(b));
    }
}