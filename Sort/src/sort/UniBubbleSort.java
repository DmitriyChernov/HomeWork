package sort;

public class UniBubbleSort 
{
    void sort(Object []a, Compare compare)
    {
	int i, j;
        Object swap;
        boolean noswap=false;
        int n = a.length;
	for (i=0;i<=n-2;i++)
	{
		for (j=0;j<n-i-1;j++)
		{
			if (compare.compare(a[j], a[j+1]) == CompareResult.Less)
			{
				swap=a[j];
				a[j]=a[j+1];
				a[j+1]=swap;
				noswap=true;
				if(!noswap)
				{
					break;
				}
			}
		}
	}
    }
}
