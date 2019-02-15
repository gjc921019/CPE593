import java.util.*;

public class hw1a {
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

    public static void main(String[] args) {
        int numTrials = 100000;
        Random rnd = new Random(0);
        for (int i = 0; i < numTrials; i++) {
            int n = rnd.nextInt(501);
            int r = rnd.nextInt(n+1);
            choose(n,r);
        }
        //double arrayTest[][] = new double[0][0];
        //System.out.println(arrayTest[1][3]);
        //if (arrayTest[0][0] !=0){
        //    System.out.println(1);
        //}
        //else {
         //   System.out.println(0);
        //}

        //double[] a = new double[1];
        //if (a[0]==0){
        //    System.out.println("yes");
        //}
        //else{
        //    System.out.println("no");
        //}


    }
}
