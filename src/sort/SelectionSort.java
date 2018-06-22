package sort;

public class SelectionSort {

    public static void sort(int[] num) {
        int i, j, first, temp;
        for (i = num.length - 1; i > 0; i--) {
            //initialize to subscript of first element
            first = 0;
            //locate smallest element between positions 1 and i.
            for (j = 1; j <= i; j++) {
                if (num[j] < num[first])
                    first = j;
            }
            //swap smallest found with element in position i.
            temp = num[first];
            num[first] = num[i];
            num[i] = temp;
        }
    }
}
