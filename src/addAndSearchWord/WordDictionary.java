package addAndSearchWord;

import java.util.*;

class TrieNode{
    char val;
    boolean isLeaf;
    Map<Character, TrieNode> children;
    TrieNode(char c) {
        this.val = c;
        isLeaf = false;
        children = new HashMap<Character, TrieNode>();
    }
}

public class WordDictionary {
    TrieNode root;
    
    public WordDictionary(){
        this.root = new TrieNode(' ');
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        addWord(root, word, 0);
    }
    
    public void addWord(TrieNode root, String word, int index){
        if(index >= word.length()) return;
        
        if(!root.children.containsKey(word.charAt(index))){
            root.children.put(word.charAt(index), new TrieNode(word.charAt(index)));
        }
        
        if(index == word.length()-1){
            root.children.get(word.charAt(index)).isLeaf = true;
            return;
        }
        addWord(root.children.get(word.charAt(index)), word, index+1);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    @SuppressWarnings("rawtypes")
	public boolean search(TrieNode root, String word, int index){
        if(index >= word.length()) return false;
        char c = word.charAt(index);
        if(c == '.'){
            Iterator it = root.children.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                TrieNode child = (TrieNode) entry.getValue();
                if(index == word.length() -1 && child.isLeaf) return true;
                if(search(child, word, index+1)) return true;
            }
            return false;
        }else if(root.children.containsKey(c)){
            if(index == word.length() -1 && root.children.get(c).isLeaf) return true;
            return search(root.children.get(c), word, index+1);
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");