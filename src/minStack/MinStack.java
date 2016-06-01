package minStack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> min;
    private Stack<Integer> store;

    /** initialize your data structure here. */
    public MinStack() {
        min = new Stack<Integer>();
        store = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.store.push(x);
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }
    
    public void pop() {
        int num = store.pop();
        if(num == min.peek()) min.pop();
    }
    
    public int top() {
        return store.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */