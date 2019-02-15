import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TrieHash {
    private class Node {
        Node[] next;
        boolean isWord;
        private Node(){
            next = new Node[26];
            for (int i = 0; i<26;i++){
                next[i] = null;
            }
            isWord = false;
        }
    }

    private Node root;
    //private MyHash[][] HashTable;
    private ArrayList<MyHash> HashArray;

    public TrieHash(){
        root = new Node();
        //HashTable = new MyHash[26][26];
        HashArray = new ArrayList<>();
        for (int i = 0; i < 26*26; i++){
            MyHash temp = new MyHash();
            HashArray.add(temp);
        }
    }

    public void add(String word){
        Node p = root;
        int[] offset = new int[2];
        for(int i = 0; i<2 && i<word.length(); i++){
            offset[i] = word.charAt(i)-'a';
            if(p.next[offset[i]]==null){
                p.next[offset[i]] = new Node();
            }
            p = p.next[offset[i]];
        }
        if(word.length()<=2){
            p.isWord = true;
        }
        else{
            String rest = word.substring(2);
            //HashTable[offset[0]][offset[1]].add(rest);
            int index = offset[0]*26+offset[1];
            HashArray.get(index).add(rest);
        }
    }

    public boolean find(String word){
        Node p = root;
        int[] offset = new int[2];
        for(int i = 0; i<2 && i<word.length(); i++){
            offset[i] = word.charAt(i)-'a';
            if(p.next[offset[i]]==null){
                return false;
            }
            p = p.next[offset[i]];
        }
        if( word.length()<=2 && p.isWord){
            return true;
        }
        else{
            String rest = word.substring(2);
            //return HashTable[offset[0]][offset[1]].find(rest);
            int index = offset[0]*26+offset[1];
            return HashArray.get(index).find(rest);
        }
    }

    public static void main (String[] args) throws IOException  {

        TrieHash dict = new TrieHash();
        BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
        String str1;
        //int count = 0;
        while ((str1 = br.readLine())!= null){
            dict.add(str1);
            //count++;
            //System.out.println(count);
        }


        // test spell!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if(dict.find("ab")){
            System.out.println("ab in the dictionary");
        }
        else{
            System.out.println("ab NOT in the dictionary");
        }
        if(dict.find("bearm")){
            System.out.println("bearm in the dictionary");
        }
        else{
            System.out.println("bearn NOT in the dictionary");
        }
        if(dict.find("google")){
            System.out.println("google in the dictionary");
        }
        else{
            System.out.println("google NOT in the dictionary");
        }
    }
}
