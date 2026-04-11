public class StackLL {
    class Node{
        int data;
        Node next;

        Node(int x){
            this.data=x;
            this.next=null;
        }
    }
    Node top;
    //push operation
    void push(int x){
        Node newNode=new Node(x);
        newNode.next=top;
        top=newNode;
    }
    //pop operation
    int pop(){
        if(top==null){
            System.out.println("stack is empty");
            return -1;
        }
        int val=top.data;
        top=top.next;
        return val;
    }
    int peek(){
        if(top==null){
            System.out.println("Stack is empty");
            return -1;
        }
        int val=top.data;
        return val;
    }
    public static void main(String[] args) {
        StackLL st=new StackLL();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println("Peekded element "+st.peek());
        System.out.println("Popped element "+st.pop());
        System.out.println("Peekded element "+st.peek());
        // st.pop();
    }
}
