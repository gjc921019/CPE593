public class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            if(A == null || A.length == 0){
                return 0;
            }
            // find next jump for each elements (odd and even)
            int n = A.length;
            int[] oddNext = new int[n];  // save next jump position
            int[] evenNext = new int[n];

            for(int i = 0; i<n-1; i++){
                int minOdd = 10000;
                int minEven = 10000;
                for(int j = i+1; j<n; j++){
                    if(A[i]<A[j]){
                        int temp = A[j] - A[i];
                        if(temp<minOdd){
                            minOdd = temp;
                            oddNext[i] = j;
                        }
                    }
                    if(A[i]>A[j]){
                        int temp = A[i] - A[j];
                        if(temp<minEven){
                            minEven = temp;
                            evenNext[i] = j;
                        }
                    }
                }
            }

            oddNext[n-1] = n-1;
            evenNext[n-1] = n-1;

            int[] oddResult = new int[n]; // 0 means unknow
            int[] evenResult = new int[n];
            oddResult[n-1] = 1; // 1 means success
            evenResult[n-1] = 1;

            int correct = 1;
            // calculate oddResult for each element
            for(int i = 0; i<n-1; i++){
                oddResult[i] = oddJump(i,oddNext,oddResult,evenNext,evenResult);
                if(oddResult[i] == 1){
                    correct++;
                }
            }

            return correct;


        }

        private int oddJump(int pos, int[] oddNext, int[] oddResult, int[] evenNext, int[] evenResult){
            if(oddResult[pos]==0){
                if(oddNext[pos]==0){
                    oddResult[pos] = -1; // -1 means fail
                }
                else{
                    oddResult[pos] = evenJump(oddNext[pos], oddNext, oddResult, evenNext, evenResult);
                }
            }
            return oddResult[pos];
        }

        private int evenJump(int pos, int[] oddNext, int[] oddResult, int[] evenNext, int[] evenResult){
            if(evenResult[pos] == 0){
                if(evenNext[pos] == 0){
                    evenResult[pos] = -1;
                }
                else{
                    evenResult[pos] = oddJump(evenNext[pos], oddNext, oddResult, evenNext, evenResult);
                }
            }
            return evenResult[pos];
        }

        public static void main(String[] args){
            int[] A = new int[]{10,13,12,14,15};
            Solution s = new Solution();
            int res = s.solution(A);
            System.out.println(res);
        }
}
