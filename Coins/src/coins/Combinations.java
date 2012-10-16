package coins;

class Combinations 
{
    private int []c;
    private int len;
    
    public Combinations(int []c) throws IllegalArgumentException
    {
        if (c==null)
        {
            System.out.println("Массив не инициализирован");
            throw new IllegalArgumentException();
        }
        this.c = c.clone();
        len=c.length;
    }
    int numberCombinations(int step, int n, int []c) 
    {
        if (n==0)
        {
            return 1;
        }
        else if (n<0)
        {
            return 0;
        }
        else if (len==step)
        {
            return 0;
        }
        else 
        {
            return numberCombinations(step+1, n, c)+ numberCombinations(step ,n-c[step], c);
        }
    }
}
