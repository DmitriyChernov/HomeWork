/*
 *Chernov Dmitriy
 * 271 group
 */

package palindrome;

public class CaseSensetivePalindrome extends Palindrome 
{
    @Override
    public boolean compare(char a, char b)
    {
         return (a != b);
    }
}
