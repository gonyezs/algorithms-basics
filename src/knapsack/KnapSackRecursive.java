package knapsack;

public class KnapSackRecursive {

    public static void main(String args[]) {
        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int maxWeight = 50;
        System.out.println(knapSack(maxWeight, weights, values, values.length));
    }

    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack of capacity maxWeight
    static int knapSack(int maxWeight, int weights[], int values[], int i) {
        // Base Case
        if (i == 0 || maxWeight == 0)
            return 0;

        // If weight of the i-th item is more than knapsack capacity maxWeight, then
        // this item cannot be included in the optimal solution
        if (weights[i - 1] > maxWeight)
            return knapSack(maxWeight, weights, values, i - 1);

            // Return the maximum of two cases:
            // (1) i-th item included
            // (2) not included
        else return max(values[i - 1] + knapSack(maxWeight - weights[i - 1], weights, values, i - 1),
                knapSack(maxWeight, weights, values, i - 1)
        );
    }
}
