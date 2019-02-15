public class SinglyLinkedList {
    private class Node {
        private int val;
        private Node next;

        public Node(int v, Node next){
            this.val = v;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public SinglyLinkedList (){
        head = null;
        tail = null;
    }

    public void addEnd(int v){
        Node p = new Node(v,null);
        if (tail!=null){
            tail.next = p;
            tail = p;
        }
        else {
            head = p;
            tail = p;
        }
    }

    public void addStart(int v){
        Node p = new Node(v,null);
        if (head!=null){
            p.next = head;
            head = p;
        }
        else{
            head = p;
            tail = p;
        }
    }

    public int size(){
        Node p;
        if (head==null){
            return 0;
        }
        int output = 1;
        for (p = head;p.next!=null;p=p.next){
            output++;
        }
        return output;
    }

    public void remove(int index){
        if(index>this.size()-1){
            return;
        }
        if (head==null){
            return;
        }
        if (head.next==null){ // now index = 0, hence remove head
                head=null;
                tail=null;
        }

        Node p=head;
        Node q=p.next;
        if (index==0){
            head = q;
        }
        for(int i = 1; i<index;i++){
            p=q;
            q=q.next;
        }
        if (q.next!=null){
            p.next = q.next;
        }
        else {
            p.next=null;
            tail=p;
        }
    }

    public int getVal(int index){
        if (index>this.size()-1){
            return -1; // assume all the val is non-negative
        }
        Node p = head;
        for (int j = 0; j <index;j++){
            p=p.next;
        }
        return p.val;
    }

    public int removeEnd(){
        if (head==null){
            return -1;
        }
        int temp = tail.val;
        if (head==tail){
            head=null;
            tail=null;
            return temp;
        }
        Node p;
        for (p=head;p.next!=tail;p=p.next);
        tail=p;
        return temp;
    }
}
