package com.company;

public class hw2_ab {
    public static void main (String[] args){
        int a = 2000000000;
        int b = 2000100000;
        int sb = (int) Math.sqrt(b);
        bitvec b1 = new bitvec (a+1,false); // use one word to represent the prime state of 64 numbers
        b1.set(0); // because 0 is not a prime
        b1.set(1); // because 1 is not a prime
        for (int i = 2; i<=(int)Math.sqrt(sb);i++){
            if(!b1.test(i)){
                for (int j = i*i; j<=sb;j+=i){
                    b1.set(j);
                }
            }
        }

        bitvec b2 = new bitvec (b-a+1,false);

        for (int i = 2; i<=sb; i++){
            if(!b1.test(i)){
                for (int j = (a/i)*i; j<=b;j+=i){
                    if(j-a>=0){
                        b2.set(j-a);
                    }
                }
            }
        }

        int count = 0;
        for (int k=0;k<=b-a;k++) {
            if(!b2.test(k)){
                count++;
                //System.out.println(k+a);  // print all prime number smaller than a
            }
        }
        System.out.println("count is "+count);  // count prime numbers
    }
}
