public class hm9 {

    public static void main(String args[]){
        double[] x = new double[]{0,25,100,200,300,400}; // coordinate x
        double[] y = new double[]{0,25,50,30,10,0}; // coordinate y
        double[] Bx = new double[]{3*(x[1]-x[0]),3*(x[2]-x[0]),3*(x[3]-x[1]),3*(x[4]-x[2]),3*(x[5]-x[3]),3*(x[5]-x[4])};
        double[] By = new double[]{3*(y[1]-y[0]),3*(y[2]-y[0]),3*(y[3]-y[1]),3*(y[4]-y[2]),3*(y[5]-y[3]),3*(y[5]-y[4])};

        double[] ax = new double[6];
        double[] bx = new double[6];
        double[] cx = new double[6];
        double[] dx = new double[6];

        double[] ay = new double[6];
        double[] by = new double[6];
        double[] cy = new double[6];
        double[] dy = new double[6];

        TriDiag matrix = new TriDiag(6,6);
        matrix.row_reduction();
        double[] Dx = matrix.back_sub(Bx);
        double[] Dy = matrix.back_sub(By);

        for (int i = 0; i<5; i++){
            ax[i] = x[i];
            bx[i] = Dx[i];
            cx[i] = 3*(x[i+1]-x[i])-2*Dx[i]-Dx[i+1];
            dx[i] = 2*(x[i]-x[i+1])+Dx[i]+Dx[i+1];
        }

        for (int i = 0; i<5; i++){
            ay[i] = y[i];
            by[i] = Dy[i];
            cy[i] = 3*(y[i+1]-y[i])-2*Dy[i]-Dy[i+1];
            dy[i] = 2*(y[i]-y[i+1])+Dy[i]+Dy[i+1];
        }

        System.out.println("coordinate (x,y) is as follow:");
        for(int i = 0; i<5; i++){
            for(double t = 0; t<=0.9; t=t+0.1){
                double tempX = dx[i]*(t*t*t) + cx[i]*(t*t) + bx[i]*t +ax[i];
                double tempY = dy[i]*(t*t*t) + cy[i]*(t*t) + by[i]*t +ay[i];
                System.out.println("(" +tempX + " , " + tempY + ")");
            }
        }


    }


}
