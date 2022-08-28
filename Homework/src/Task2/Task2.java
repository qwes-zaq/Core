package Task2;

public class Task2 {
    public static void main(String[] args)
    {
        int[] array = {5,6,3,2,5,1,4,9};

        quickSort(array);

        assertMock(isArrayEqual(array, new int[]{1,2,3,4,5,5,6,9}));
    }
    public static void quickSort(int[] array)
    {
        quickSort(array, 0, array.length-1);
    }
    public static void quickSort(int[] array, int l, int r)
    {
        int w,m, n=r-l+1, ll=l, rr=r;
        if(n<=1) return;
        if(n==2)
        {
            if(array[l]>array[r])
            {
                w = array[l];
                array[l] = array[1];
                array[1] = w;
                return;
            }
        }
        m=array[(l+r)/2];
        while(l<=r)
        {
            while(array[l]<m) l++;
            while(array[r]>m) r--;
            if (l<=r)
            {
                w = array[l];
                array[l] = array[r];
                array[r] = w;
                l++; r--;
            }
        }
        quickSort(array, ll, r);
        quickSort(array, l, rr);
        return;
    }
    public static boolean isArrayEqual(int[] array1, int[] array2)
    {
        if(array1.length!=array2.length)
        {
            return false;
        }
        for(int i=0;i<array1.length;i++)
        {
            if(array1[i]!=array2[i])
            {
                return false;
            }
        }

        return true;
    }
    public static void assertMock(boolean x)
    {
        if(!x)
        {
            throw new RuntimeException("Тест не пройден");
        }
        else
        {
            System.out.println("Тест пройден");
        }
    }
}
