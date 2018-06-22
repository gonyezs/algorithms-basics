package sort;

public class InsertionSort {

    public static void sort(int[] numbers) {
        int j;   // the number of items sorted so far
        int key; // the item to be inserted
        int i;
        // Start with 1 (not 0)
        for (j = 1; j < numbers.length; j++) {
            key = numbers[j];
            // Smaller values are moving up
            for (i = j - 1; (i >= 0) && (numbers[i] < key); i--) {
                numbers[i + 1] = numbers[i];
            }
            // Put the key in its proper location
            numbers[i + 1] = key;
        }
    }
}