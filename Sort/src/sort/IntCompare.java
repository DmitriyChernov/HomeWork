package sort;
class IntCompare implements Compare 
{
    @Override
    public CompareResult compare(Object a, Object b) 
    {
        if ((Integer)a > (Integer) b) 
        {
            return CompareResult.Larger;
        } else {
            if ((Integer)a < (Integer) b) 
            {
                return CompareResult.Less;
            }
        }
        return CompareResult.Equal;
    }
}