public class MyHash {
    private String[] table;
    int capacity = 15000;
    int used;

    public MyHash(){
        table = new String[capacity];
        used = 0;
    }

    private int HashFunc(String word){
        int sum = 0;
        for (int i = 0; i < word.length(); i++){
            sum = sum + (word.charAt(i)-'a')*(26^i);
        }
        return sum%capacity;
    }

    private void grow(){
        String [] old = table;
        capacity = 2*capacity;
        table = new String[capacity];
        for (int i = 0; i<old.length;i++){
            table[i] = old[i];
        }
    }

    public void add(String word){
        if (used >= capacity/2){
            this.grow();
        }
        int pos = HashFunc(word);
        while(table[pos]!=null){
            if(table[pos].equals(word)){
                return;
            }
            pos++;
        }
        table[pos] = word;
        used++;
    }

    public boolean find(String word){
        int pos = HashFunc(word);
        while(table[pos]!=null){
            if(table[pos].equals(word)){
                return true;
            }
            pos++;
        }
        return false;
    }
}
