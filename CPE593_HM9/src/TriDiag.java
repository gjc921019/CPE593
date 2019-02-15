public class TriDiag {
    public int row;
    public int col;
    public double[][] m;

    public TriDiag(int r,int c){
        row = r;
        col = c;
        m = new double[row][col];
        for (int i = 1; i<row-1; i++){
            for (int j = 0; j<col; j++){
                if(Math.abs(j-i)==1){
                    m[i][j] = 1;
                }
                if(j==i){
                    m[i][j]=4;
                }
            }
        }
        m[0][0]=2;
        m[0][1]=1;
        m[row-1][col-2]=1;
        m[row-1][col-1]=2;
    }

    public void row_reduction(){
        int j = 0;
        for (int i = 0; i < row-1; i++){
            double p = m[i+1][j]/m[i][j];
            for (int k = 0; k< col; k++){
                m[i+1][k] = m[i+1][k]-p*m[i][k];
            }
            j++;
        }
    }

    public double[] back_sub(double[] input){ // input row == output row
        double[] output = new double[row];
        output[row-1] = input[row-1]/m[row-1][row-1];  // row == col
        for (int i = row-2; i>=0;i--){
            output[i] = (input[i]-output[i+1])/m[i][i];
        }
        return output;
    }

    public static void main(String[] args){
        TriDiag matrix = new TriDiag(6,6);
        System.out.println(matrix.m[1][0]+" "+matrix.m[1][1]);
        matrix.row_reduction();
        for (int i = 0; i<5; i++){
            System.out.println(matrix.m[i+1][i]+" "+matrix.m[i+1][i+1]);
        }
        double[] input = new double[]{1,2,3,4,5,6};
        double[] d = matrix.back_sub(input);
        for (int i = 0; i<6; i++){
            System.out.println(d[i]);
        }
    }
}
