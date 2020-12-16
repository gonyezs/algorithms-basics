package basic;

public class Fibonacci {

    public static void main ( String[] args ) {
        // Print the fist 10 fibonacci number
        for ( int i = 0; i < 10; i++ ) {
            System.out.print ( fibonacci(i) + ", " );
        }

        // Print the 10th fibonacci number
        System.out.println ( fib(9) );
    }

    // Recursive
    static long fib(int n) {
        return n <= 1 ? n : fib(n-1) + fib(n-2);
    }

    // Iterative
    static int fibonacci (int n) {
        int x = 0, y= 1, z = 1;

        for(int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }

        return x;
    }
}
