public class GrowArray {

    private int capacity;
    private int size;
    private int[] p;

    public GrowArray(){
        p = new int[1];
        capacity = 1;
        size = 0;
    }

    public int[] checkGrow(int[] p){
        if(size == capacity){
            int[] temp = p;
            int[] p =new int[capacity*2];
            for(int  i = 0; i<size; i ++){
                p[i] = temp[i];
            }
        }
    }

    public void addEnd(int v){
        p = checkGrow(p);
        p[size] = v;
        size++;
    }

    public void addStart(int v){
        p= checkGrow(p);
        int[] temp = p;
        p = new int[size+1];
        p[0] = v;
        for(int i = 1; i<size;i++){
            p[i] = temp[i-1];
        }
        size++;
    }

    public void removeStart(){
        for(int i = 0; i < size; i++){
            p[i] = p[i+1];
        }
        size--;
    }

    public void removeEnd(){
        size--;
    }
}
