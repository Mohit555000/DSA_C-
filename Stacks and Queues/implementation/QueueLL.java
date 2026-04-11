public class QueueLL {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node front,rear;
    //add
    void enqueue(int x){
        Node newNode=new Node(x);
        if(rear==null){
            front=rear=newNode;
        }
        rear.next=newNode;
        rear=newNode;
    }
    //pop
    int dequeue(){
        if(front==null){
            System.out.println("Empty queue");
            return -1;
        }
        .int val=frontdata;
        front=front.next;
        return val;
    }
    //peek
    int peek(){
        if(front==null){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    boolean isEmpty(){
        if(front==null){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        QueueLL q = new QueueLL();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.peek());

        System.out.println(q.dequeue() + " removed");
        System.out.println(q.dequeue() + " removed");
    }
}
