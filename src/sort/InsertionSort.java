package sort;

public class InsertionSort {

    public static void insertionSort(int[] numbers) {
        int j;   // the number of items sorted so far
        int key; // the item to be inserted
        int i;
        // Start with 1 (not 0)
        for (j = 1; j < numbers.length; j++) {
            key = numbers[j];
            for (i = j - 1; (i >= 0) && (numbers[i] < key); i--)   // Smaller values are moving up
            {
                numbers[i + 1] = numbers[i];
            }
            numbers[i + 1] = key;    // Put the key in its proper location
        }
    }
}

