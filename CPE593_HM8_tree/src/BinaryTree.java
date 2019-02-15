import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class BinaryTree {

    public static class Node{
        public String val;
        public Node left, right;

        public Node(String v, Node L, Node R){
            this.val = v;
            this.left = L;
            this.right = R;
        }


        public void inOrder(){
            if(this.left!=null){
                this.left.inOrder();
            }
            System.out.print(this.val);
            if(this.right!=null){
                this.right.inOrder();
            }
        }

        public void preOrder(){
            System.out.print(this.val);
            if(this.left!=null){
                this.left.preOrder();
            }
            if(this.right!=null){
                this.right.preOrder();
            }
        }

        public void postOrder(){
            if(this.left!=null){
                this.left.postOrder();
            }
            if(this.right!=null){
                this.right.postOrder();
            }
            System.out.print(this.val);
        }
    }

    private Node root;

    public BinaryTree(){
        root = null;
    }

    public void PrintinOrder(){
        if(root==null){
            return;
        }
        else{
            root.inOrder();
        }
        System.out.println();
    }

    public void PrintpreOrder(){
        if(root==null){
            return;
        }
        else{
            root.preOrder();
        }
        System.out.println();
    }

    public void PrintpostOrder(){
        if(root==null){
            return;
        }
        else{
            root.postOrder();
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hw8inp.dat"));
        String str;
        while ((str = br.readLine())!= null){
            String[] input = str.split("\\s+");
            BinaryTree t = new BinaryTree();
            //String[] input = new String[]{"x","x","-","a","b","+","*"};
            Stack<Node> st1 = new Stack<Node>();
            for (String s : input){
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                    t.root = new Node(s,null,null);
                    //t.root = new Node(s,st1.pop(),st1.pop());
                    t.root.right = st1.pop();
                    t.root.left = st1.pop();
                    st1.push(t.root);
                }
                else{
                    Node temp = new Node(s,null,null);
                    st1.push(temp);
                }
            }
            t.PrintinOrder();
            t.PrintpreOrder();
            t.PrintpostOrder();

            Stack<Integer> st2 = new Stack<Integer>();
            int temp1;
            int temp2;
            int result;
            for (String s : input){
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                    if(s.equals("+")){
                        temp2 = st2.pop();
                        temp1 = st2.pop();
                        result = temp1+temp2;
                    }
                    else if (s.equals("-")){
                        temp2 = st2.pop();
                        temp1 = st2.pop();
                        result = temp1 -temp2;
                    }
                    else if (s.equals("*")){
                        temp2 = st2.pop();
                        temp1 = st2.pop();
                        result = temp1 * temp2;
                    }
                    else {
                        temp2 = st2.pop();
                        temp1 = st2.pop();
                        result = temp1 / temp2;
                    }
                    st2.push(result);
                }
                else{
                    try{
                        st2.push(Integer.parseInt(s));
                    }catch (Exception e){
                        st2.push(0);
                    }
                }
            }
            System.out.println(st2.pop());
            System.out.println("*********************");
        }



    }




}
