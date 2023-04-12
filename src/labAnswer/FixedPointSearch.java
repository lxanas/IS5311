package labAnswer;

public class FixedPointSearch {
	/*
		A method for finding an element in arr 
		such that the element value equals to its index.
	*/
	public Integer search(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mIndex = (start + end) / 2;
		if (arr[mIndex] == mIndex)
			return mIndex;
		else if (arr[mIndex] > mIndex)
			return search(arr, start, mIndex-1);
		else
			return search(arr, mIndex+1, end);
	}
}