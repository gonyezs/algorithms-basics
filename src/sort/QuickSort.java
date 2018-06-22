package sort;

import java.util.Arrays;

/**
 * Select a pivot, normally the middle one
 * From both ends, swap elements and make all elements on the left less than the pivot and all elements on the right greater than the pivot
 * Recursively sort left part and right part
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] x = {9, 2, 4, 7, 3, 7, 10};
        System.out.println("Unsorted array before sorting : " + Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Sorted array after sorting : " + Arrays.toString(x));
    }

    public static void quickSort(int[] numbers, int low, int high) {
        if (numbers == null || numbers.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = numbers[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }

            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(numbers, low, j);

        if (high > i)
            quickSort(numbers, i, high);
    }
}