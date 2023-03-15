package week9;

import java.util.Random;

public class TestFixedPointSearch {
	
	/*
		The method below generates an array 
		with random integer values in increasing 
		order and the size is random from 10000 to 50000000.
	*/
	public static int[] generateHugeArray() {
		System.out.println("Creating the random array...");
		final int MIN_SIZE = 10000;
		final int MAX_SIZE = 50000000;
		Random rand = new Random();
		
		// Create a random size array with min size is MIN_SIZE
		int arraySize = Math.max(MIN_SIZE, rand.nextInt(MAX_SIZE+1));
		int[] array = new int[arraySize];
		
		array[0] = rand.nextInt(MAX_SIZE) - MAX_SIZE/2;
		
		for (int i = 1; i < arraySize; i++) {
			int stepSize = rand.nextInt(4) + 1;
			array[i] = array[i-1] + stepSize;
		}
		return array;
	}
	
	public static void main(String[] args) {
		// Below provides 4 defintion of myArray
		// for testing purpose. Use only one defintion
		// at a time.

		// Use the array below, the result should print 4
//		int[] myArray = { -3, -2, 0, 2, 4, 8 };

		// Use the array below, the result should print EITHER 4 OR 5
		//int[] myArray = { -3, -2, 0, 2, 4, 5, 8 };
		
		// Use the array below, the result should print 
		// No fixed point exist in the array
		//int[] myArray = { -3, -2, 0, 2, 8 };
		
		// The one below generate a hugh array with random
		// content but sorted in increasing order
		int[] myArray = generateHugeArray();
		
		// Prints the array size
		System.out.println("Array size: " + myArray.length);
		
		// Records the current time in nanosecond. 
		// **Out of syallbus, you don't need to know this.**
		long start1 = System.nanoTime();
		
		// Create a FixedPointSearch object and assign 
		// its memory address to the variable fixedPointSearch
		FixedPointSearch fixedPointSearch = new FixedPointSearch();

		// Call the search method of FixedPointSearch for 
		// search a fixed point from 0 to the last index
		Integer result = fixedPointSearch.search(myArray, 0, myArray.length - 1);
		
		if (result != null)
			System.out.println("A fixed point is found: index is " + result + ", value is " + myArray[result]);
		else
			System.out.println("No fixed point exist in the array");
		
		// Records the current time in nanosecond. 
		// **Out of syallbus, you don't need to know this.**
		long end1 = System.nanoTime();
		
		// Print the total nanoseconds that is used for the searching.
		System.out.println("Search special item takes " + (end1 - start1)/1000000000.0 + "s");
	}

}