package LRUcache;

import java.util.*;

class Node{
    int key, value;
    Node pre, next;
    Node(int key, int value){
    	this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private int capacity, count;
    private Node head, tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        moveFirst(node);
        
        return node.value;
    }
    
    public void set(int key, int value) {
        if(!map.containsKey(key)){
            Node node = new Node(key, value);
            map.put(key, node);
            addFirst(node);
            this.count++;
            if(this.count > this.capacity){
                deleteLast();
                count--;
            }
        }else{
            Node node = map.get(key);
            node.value = value;
            moveFirst(node);
        }
    }
    
    //TODO: move current node to head
    public void moveFirst(Node node){
        //delete current relationship
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        
        //add to the first position
        Node first = this.head.next;
        this.head.next = node;
        node.pre = this.head;
        node.next = first;
        first.pre = node;
    }
    
    //TODO: add a new node to First
    public void addFirst(Node node){
        Node first = this.head.next;
        this.head.next = node;
        node.pre = this.head;
        node.next = first;
        first.pre = node;
    }
    
    //TODO: delete last elements in the tail
    public void deleteLast(){
        Node last = this.tail.pre;
        this.tail.pre = last.pre;
        last.pre.next = this.tail;
        
        //remove relation of the 'last' element so that it can be gc.
        last.pre = null;
        last.next = null;
        
        //remove information in map
        this.map.remove(last.key);
    }
    
    public static void main(String[] args){
    	LRUCache cache = new LRUCache(1);
    	cache.set(2, 1);
    	System.out.println("GET 2: " + cache.get(2));
    	cache.set(3, 2);
    	System.out.println("GET 2: " + cache.get(2));
    	System.out.println("GET 3: " + cache.get(3));
    	
    }
}