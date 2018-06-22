package search;

public class BinarySearch {

    /**
     * Search the key in the array and returns with its index
     *
     * @param numbers - sorted list
     * @param key     - number
     * @return - index of number
     */
    public static int indexOf(int[] numbers, int key) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2; // Define the mid index
            if (key < numbers[mid])
                hi = mid - 1; // If the key is less than the mid element, search in the first half interval
            else if (key > numbers[mid])
                lo = mid + 1; // If the key is higher than the mid element, search in the second half interval
            else return mid;
        }
        return -1;
    }

}
