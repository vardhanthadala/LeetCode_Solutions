class MyStack {
  Queue<Integer>q1;
  Queue<Integer>q2;
  int topElement;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        topElement=x;
    }
    
    public int pop() {
        while(q1.size()>1){
        topElement=q1.remove();
        q2.add(topElement);
       }
       int poppedElement=q1.remove();
        Queue<Integer> temp = q1;
        q1=q2;
        q2=temp;
        return poppedElement;
    }
    
    public int top() {
       return topElement; 
    }
    
    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
}
