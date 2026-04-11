import java.util.Arrays;

public class QueueArray {
    int capacity;
    int front;
    int rear;
    int [] queue;

    QueueArray(int size){
        capacity=size;
        front=0;
        rear=-1;
        queue=new int[size];
    }
    void enqueue(int x){
        if(rear==capacity-1){
            System.out.println("Queue is full");
            return;
        }
        queue[++rear]=x;
    }
    int dequeue(){
        if(front>rear){
            System.out.println("Queue underflow");
            return -1;
        }
        return queue[front++];
    }
    int peek(){
        if(front>rear){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.peek());

        System.out.println(q.dequeue() + " removed");
        System.out.println(q.dequeue() + " removed");

        // Print full array
        System.out.println(Arrays.toString(q.queue));
    }
}
