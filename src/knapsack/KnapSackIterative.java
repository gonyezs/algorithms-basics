package knapsack;

import java.util.HashSet;
import java.util.Set;

public class KnapSackIterative {

    // Returns the maximum value that can be put in a knapsack of capacity maxWeight
    static Set<Integer> knapSack(int maxWeight, int weights[], double values[], int length) {
        Set<Integer> indexes = new HashSet<>();
        double table[][] = new double[length + 1][maxWeight + 1];

        for (int i = 0; i <= length; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                // Feltoltom a nulladik sort es oszlopot nullakkal
                if (i == 0 || w == 0) {
                    table[i][w] = 0;
                }
                // Ha az iteralt suly nagyobb vagy egyenlo az aktuais sulyerteknel
                else if (weights[i - 1] <= w) {

                    // Aktualis ertek + a tabla [iteralt suly - aktualis suly] erteke az elozo sorban
                    double value1 = values[i - 1] + table[i - 1][w - weights[i - 1]];

                    // A tabla ugyanezen eleme az elozo sorban
                    double value2 = table[i - 1][w];

                    // Beallitom aktualis erteknek amelyik nagyobb, es belerakom az indexet a set-be
                    if (value1 > value2) {
                        table[i][w] = value1;
                        if (i - 1 > 0) indexes.add(i - 1);
                    } else {
                        table[i][w] = value2;
                    }

                } else {
                    // Ha az iteralt suly kisebb az aktuais sulyerteknel
                    // Beallitom az elozo sor ugyanezen elemet
                    table[i][w] = table[i - 1][w];
                }
            }
        }

        printGrid(table);

        return indexes;
    }

    // ---- Testing ----

    public static void main(String args[]) {
        double values[] = new double[]{1.33, 6.21, 3.44, 6.33};
        int weights[] = new int[]{1, 2, 3, 4};
        int maxWeight = 5;

        Set<Integer> indexes = knapSack(maxWeight, weights, values, values.length);
        System.out.println(indexes);

        for (Integer i : indexes) {
            System.out.print(values[i] + ",");
        }
    }

    public static void printGrid(double table[][]) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

}
