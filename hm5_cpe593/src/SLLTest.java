public class SLLTest {
    public static void main(String args[]){
        SinglyLinkedList sll = new SinglyLinkedList();
        int n=10;
        for (int i = 1; i<=n;i++){
            sll.addEnd(i);
            //System.out.println(sll.getVal(i));
        }
        for (int i = sll.size()-1; i >= 0;i--){
            if (i%3==0){
                sll.remove(i);
            }
        }
        for (int i = sll.size()-1; i >= 0;i--){
            if (i%3==0){
                sll.remove(i);
            }
        }
        for (int i = 0; i < sll.size();i++){
            System.out.println(sll.removeEnd());
        }

    }
}
