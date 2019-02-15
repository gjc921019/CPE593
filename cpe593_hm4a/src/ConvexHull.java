import java.util.ArrayList;
import java.util.Arrays;

public class ConvexHull {
    public static void main(String args[]){
        int n =16;
        int number = 10000;
        double[] x =new double[number];
        double[] y =new double[number];
        double x_max = 0;
        double x_min = 100;
        double y_max = 0;
        double y_min = 100;
        for (int i = 0; i< number; i++){
            x[i] = Math.random()*100;
            if (x[i]>x_max){
                x_max = x[i];

            }
            if (x[i]<x_min){
                x_min = x[i];
            }
            y[i] = Math.random()*100;
            if (y[i]>y_max){
                y_max = y[i];
            }
            if (y[i]<y_min){
                y_min = y[i];
            }
        }

        double XperBox  = 1/(x_max-x_min);
        double YperBox = 1/(y_max-y_min);

        ArrayList<GrowArray> grid = new ArrayList<>();
        for (int i =0; i< 256;i++){
            GrowArray original = new GrowArray();
            grid.add(original);
        }
        //grid.get(0).insertEnd(new Point(1,2));

        int row;
        int col;
        for (int i = 0; i<number; i++){
            row = (int)((y[i]-y_min-0.01)*YperBox*n);
            col = (int)((x[i]-x_min-0.01)*XperBox*n);
            Point cur = new Point(x[i],y[i]);
            grid.get(row*n+col).insertEnd(cur);
        }
        //Point temp = grid.get(150).getPoint(0);
        //System.out.println(temp.getX()+" "+ temp.getY());
        int[] BoxSize = new int[256];
        System.out.println("The size of each box from box 0 to box 255");
        for (int i = 0; i<256;i++){
            BoxSize[i] = grid.get(i).getSize();
        }
        System.out.println(Arrays.toString(BoxSize));

        System.out.println();

        System.out.println("Min and max value for the whole dateSet");
        System.out.println(x_min+" "+x_max+" "+y_min+" "+y_max);

        System.out.println();

        System.out.println("Min and max value for each box around the perimeter ");
        int count = 0;
        for (int i = 0; i< 15; i++){
            double[] output = grid.get(i).getMinMax();
            System.out.println(Arrays.toString(output));
            count++;
        }

        for (int i = 31; i<256; i=i+16){
            double[] output = grid.get(i).getMinMax();
            System.out.println(Arrays.toString(output));
            count++;
        }

        for (int i = 255; i>=240;i--){
            double[] output = grid.get(i).getMinMax();
            System.out.println(Arrays.toString(output));
            count++;
        }

        for (int i = 224; i>0;i = i-16){
            double[] output = grid.get(i).getMinMax();
            System.out.println(Arrays.toString(output));
            count++;
        }
        //System.out.println(count);
    }
}
