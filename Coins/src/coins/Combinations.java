package coins;

class Combinations 
{
    private int len=0;
    private int head;
    
    int numberCombinations(int n, int []c)
    {
        len=c.length;
        if (n==0)
        {
            return 1;
        }
        else if (n<0)
        {
            return 0;
        }
        else if (len==0)
        {
            return 0;
        }
        else 
        {
            int []b = null;
            System.arraycopy(c, 2, b, 1, len-1);
            return numberCombinations(n, b)+ numberCombinations(n-c[1], c);
        }
    }
}
