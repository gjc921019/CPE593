import java.util.*;

public class hw1m {
    private static double memo[][] = new double[501][501];

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
        int numTrials = 100000000;
        Random rnd = new Random(0);
        for (int i = 0; i < numTrials; i++) {
            int n = rnd.nextInt(501);
            int r = rnd.nextInt(n+1);
            //int n = rnd.nextInt(31);
            //int r = rnd.nextInt(n+1);
            choose(n,r);
        }
    }
}
