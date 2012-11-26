/*
 *Chernov Dmitriy
 * 271 group
 */

package palindrome;

public abstract class Palindrome
{
    public abstract boolean compare (char a, char b);
            
    public boolean isPalindrome(String s) 
    {
        if (s == null) 
        {
            throw new IllegalArgumentException("Строка не инициализирована");
        }
        int i, left = 0;
        int right = s.length() - 1;
        IsLetterOrDigit p = new IsLetterOrDigit();
        while (left < right) 
        {
            while (!p.isLetterorDigit((s.charAt(left))))
            {
                left++;
                if (left > right) 
                {
                    return true;
                }
            }

            while (!p.isLetterorDigit((s.charAt(right))))
            {
                right--;
            }

            if (compare(s.charAt(left) , s.charAt(right)))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
