public class GrowArray {
    private	int capacity; // the size of the block of memory
    private int size;     // how many are used
    private Point[] p;       // pointer to the block

    public GrowArray() {
        capacity = 1;
        size = 0;
        p = new Point[capacity];
    }
    public GrowArray(int initialSize) {
        capacity = initialSize;
        size = 0;
        p = new Point[capacity];
    }

    private void checkGrow() { // double in size!!!
        if (this.capacity<=this.size){
            this.capacity = this.capacity*2+1;
            Point[] old = this.p;
            this.p = new Point[this.capacity];
            for (int i = 0; i < old.length; i++){
                this.p[i] = old[i];
            }
        }
    }

    public void insertEnd(Point v) { //O(1)
        checkGrow();
        p[size++] = v;
    }
    public void insertStart(Point v) { //O(n)
        checkGrow();
        //for (int i = size-1; i>= 0 ; i--){
          //  p[i+1] = p[i];
        //}
        //p[0] = v;
        //size++;
        Point[] old = p;
        for (int i = 0; i<size; i++){
            p[i+1] = old[i];
        }
        p[0] = v;
        size++;
    }
    public void insert(int pos, Point v) { //O(n)
        Point[] old = p;
        checkGrow();
        for (int i = 0; i<pos; i++){
            p[i] = old[i];
        }
        p[pos] = v;
        for (int i = pos; i<size; i++){
            p[i+1] = old[i];
        }
        size++;
    }
    public void removeStart() {  // O(n)
        size--;
        for (int i = 0; i<size;i++){
            p[i] = p[i+1];
        }
    }

    public void removeEnd() {
        size--;
    }

    public Point getPoint(int pos){
        return p[pos];
    }

    public int getSize(){
        return size;
    }

    public double[] getMinMax(){
        double x_max = 0;
        double x_min = 100;
        double y_max = 0;
        double y_min = 100;
        for (int i = 0; i<size; i++){
            if(this.getPoint(i).getX()>x_max){
                x_max = this.getPoint(i).getX();
            }
            if(this.getPoint(i).getX()<x_min){
                x_min = this.getPoint(i).getX();
            }
            if(this.getPoint(i).getY()>y_max){
                y_max = this.getPoint(i).getY();
            }
            if(this.getPoint(i).getY()<y_min){
                y_min = this.getPoint(i).getY();
            }
        }
        double[] output = new double[]{x_min,x_max,y_min,y_max};
        return output;
    }

    public static void main(String[] args) {
        GrowArray b = new GrowArray();
       // for (int i = 0; i < 10; i++)
       //     b.insertEnd(i);
        //for (int i = 0; i < 10; i++)
        //    b.insertStart(i);
        //System.out.println(b);
        //for (int i = 0; i < 10; i++)
          //  b.removeStart();
        //b.removeEnd();
        //System.out.println(b);
        //b.insert(5,1);
        Point v = new Point(1,2);
        b.insertEnd(v);
        b.getPoint(0);
        System.out.println(b);
    }

}
