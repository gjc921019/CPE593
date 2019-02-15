public class hw1aTest {
    public static double factorial (int x){
        double result = x;
        if (x==1 || x==0){
            result = 1;
        }
        else {
            while (x>1){
                result = result*(x-1);
                x=x-1;
            }
        }
        return result;
    }

    public static double choose(int n, int r) {
        double result = factorial(n)/(factorial(r)*factorial((n-r)));
        return result;
    }

    public static int fibo(int n){
        int[] memo = new int[n];
        if (n<=2){
            return 1;
        }
        if(memo[n-1] !=0){
            return memo[n-1];
        }
        else {
            return memo[n-1] = fibo (n-1) +fibo(n-2);
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

        //System.out.println("Large number tests\n");
        //System.out.println(choose(52, 6));
        //System.out.println(choose(52, 26));
        //System.out.println(choose(150, 5));
        //System.out.println(choose(6, 3));

        int r = fibo(45);
        System.out.println(r);
    }
}
