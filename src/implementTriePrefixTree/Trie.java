package implementTriePrefixTree;

import java.util.*;

class TrieNode {
    // Initialize your data structure here.
    public char val;
    public Map<Character, TrieNode> children;
    public boolean isLeaf;
    
    public TrieNode(char val) {
        this.val = val;
        this.children = new HashMap<Character, TrieNode>();
        this.isLeaf = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(root, word, 0);
    }
    
    public void insert(TrieNode root, String word, int index){
        if(index >= word.length()) return;
        char c = word.charAt(index);
        if(root.children.containsKey(c)){
            TrieNode node = root.children.get(c);
            if(index == word.length()-1) node.isLeaf = true;
            insert(node, word, index+1);
        }else{
            TrieNode node = new TrieNode(c);
            root.children.put(c, node);
            if(index == word.length()-1) node.isLeaf = true;
            insert(node, word, index+1);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word, 0, false);
    }
    
    public boolean search(TrieNode root, String word, int index, boolean prefix){
        if(index >= word.length()) return false;
        char c = word.charAt(index);
        if(root.children.containsKey(c)){
            if(index == word.length()-1) return prefix ? true : root.children.get(c).isLeaf;
            return search(root.children.get(c), word, index+1, prefix);
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return search(this.root, prefix, 0, true);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");