import java.util.Arrays;

public class StackArray {
    int capacity;
    int top;
    int [] stack;
    public StackArray(int size){
        capacity=size;
        stack=new int[capacity];
        top=-1;

    }
    //push operation
    void push(int x){
        if(top==capacity-1){
            System.out.println("Stack overflow");
            return;
        }
        top++;
        stack[top]=x;
    }
    //pop
    int pop(){
        if(top==-1){
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
        
    }
    //peek
    int peek(){
        if(top==-1){
            System.out.println("stack is empty");
            return -1;
        }
        return stack[top];
    }
    //empty
    boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        StackArray st=new StackArray(10);
        st.push(1);
        System.out.println(Arrays.toString(st.stack));
        st.pop();
        System.out.println(Arrays.toString(st.stack));
        
    }
}
