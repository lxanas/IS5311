package week9;

public class FixedPointSearch
{
    /*
        A method for finding an element in arr
        such that the element value equals to its index.
    */
    public Integer search(int[] arr, int start, int end)
    {
        if(start>end) return null;
        int mid=(start+end)/2;
        if(arr[mid]==mid)
            return mid;
        else if(arr[mid]>mid)
            return search(arr,start,mid-1);
        else
            return search(arr,mid+1,end);
    }
}