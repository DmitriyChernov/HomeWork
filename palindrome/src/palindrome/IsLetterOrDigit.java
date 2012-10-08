package palindrome;

public class IsLetterOrDigit 
{
    boolean isLetterorDigit(char c)
    {
        if (Character.isDigit(c) || Character.isLetter(c))
        {
            return true;
        }
        return false;
    }
}
