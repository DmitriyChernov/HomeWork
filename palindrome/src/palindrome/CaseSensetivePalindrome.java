package palindrome;

public class CaseSensetivePalindrome extends Palindrome {
    @Override
    public boolean isPalindrome(String s)
    {
        if (s == null) {
            throw new IllegalArgumentException("Строка не инициализирована");
        }
        int i, length;
        length=s.length();
        for(i=0;i<(length/2);i++)
        {
            if (s.charAt(i) != s.charAt(s.length()-i-1))
            {
                return false;
            }
        }
        return true;
    }
    
}
