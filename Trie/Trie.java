class Trie {

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
        int prefixCount;
    }
    private final Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new Node();

            }
            current.children[index].prefixCount++;
            current = current.children[index];
        }
        current.isEnd = true;
    }
    public boolean search(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isEnd;
    }
    public boolean startsWith(String prefix){
        Node current = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }
    public int countWordsWithPrefix(String prefix){
        Node current = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(current.children[index]==null) return 0;
            current = current.children[index];
        }
        return current.prefixCount;
    }
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("ape");
        trie.insert("application");
        trie.insert("banana");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("ap"));      // false
        System.out.println(trie.search("banana"));  // true

        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("ap"));  // true
        System.out.println(trie.startsWith("ban")); // true
        System.out.println(trie.startsWith("xyz")); // false

        System.out.println("Prefix app: " + trie.countWordsWithPrefix("app")); // 3
        System.out.println("Prefix ap: " + trie.countWordsWithPrefix("ap"));   // 4
        System.out.println("Prefix ban: " + trie.countWordsWithPrefix("ban")); // 1
        System.out.println("Prefix xyz: " + trie.countWordsWithPrefix("xyz")); // 0
    }
}

