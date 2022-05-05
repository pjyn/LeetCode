class MyStack {
    Queue<Integer> q = new LinkedList<>();
    
    public MyStack() {

    }
    
    public void push(int x) {
        q.offer(x);
        for(int i=1; i<q.size(); i++)
            q.offer(q.remove());    
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}