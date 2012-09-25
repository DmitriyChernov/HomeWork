package palindrome;

public class CaseInsensetivePalindrome extends Palindrome {
    @Override
    public boolean isPalindrome(String s)
    {
        if (s == null) {
            throw new IllegalArgumentException("Строка не инициализирована");
        }
        s = s.toLowerCase();
        int i, length;
        length=s.length();
        for(i=0;i<(length/2);i++)
        {
            if (s.charAt(i) != s.charAt(length-i-1))
            {
                return false;
            }
        }
        return true;
    }   
}