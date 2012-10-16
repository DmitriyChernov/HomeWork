/*
 *Chernov Dmitriy
 * 271 group
 */

package palindrome;

public class CaseInsensetivePalindrome extends Palindrome {

    @Override
    public boolean isPalindrome(String s) 
    {
        if (s == null) 
        {
            throw new IllegalArgumentException("Строка не инициализирована");
        }
        int i, left = 0;
        int right = s.length() - 1;
        IsLetterOrDigit p = new IsLetterOrDigit();
        while (left < right) {
            while (!p.isLetterorDigit(Character.toLowerCase(s.charAt(left))))
            {
                left++;
                if (left > right) 
                {
                    return true;
                }
            }

            while (!p.isLetterorDigit(Character.toLowerCase(s.charAt(right))))
            {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}