package search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gonyezsolt on 14/11/2016.
 */
public class LinearSearch {

    public static int largest ( int[] input ) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if ( input[i] > max ) max = input[i];
        }
        return max;
    }

    static int secondHighest(int... nums) {
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > high1) {
                high2 = high1;
                high1 = num;
            } else if (num > high2) {
                high2 = num;
            }
        }
        return high2;
    }

    Map map = new HashMap();
}
