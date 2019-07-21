class MyStack {

    private ArrayDeque<Integer> stack;
    
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new ArrayDeque<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        ArrayDeque<Integer> nStack = new ArrayDeque<Integer>();
        nStack.add(x);
        
        while(stack.peek() != null)
        {
            nStack.add(stack.pop());
        }
        
        stack = nStack;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return stack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.peek() == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */