import java.util.*;

public class hw1mTest {
    private static double memo[][] = new double[500][500];

    public static double choose(int n, int r) {
        //double memo[][] = new double[n+1][n+1];
        if (r == 0 || r==n){
            return 1;
        }
        if (memo[n][r] != 0){
             return memo[n][r];
        }
        else {
             return memo[n][r] = choose(n-1,r-1)+choose(n-1,r);
        }
    }

    public static void main(String[] args) {
        int testCases[][] = new int[][]{
                {0, 0, 1},

                {1, 0, 1},
                {1, 1, 1},

                {2, 0, 1},
                {2, 1, 2},
                {2, 2, 1},

                {5, 0, 1},
                {5, 1, 5},
                {5, 2, 10},

                {6, 3, 20}
        };

        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i][0];
            int r = testCases[i][1];
            int result = testCases[i][2];

            if (choose(n, r) != result) {
                System.err.println("Failed test case: choose(" + n + ", " + r + ") = " +
                        result + '\n');
            }
        }

        System.out.println("Large number tests\n");
        //System.out.println(choose(52, 6));
        System.out.println(choose(499, 20));
        //System.out.println(choose(6, 3));
    }
}
