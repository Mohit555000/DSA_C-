//https://youtu.be/NKJnHewiGdc?si=KSL1kfjXInGGi0KH
import java.util.*;
class SmallHeap{
    int[] heap=new int[10];
    int size=0;

    public void insert(int value){
        if(size>=heap.length){
            return;
        }
        heap[size]=value;
        int current=size;
        while(current>0){
            int parent=(current-1)/2;
            if(heap[current]>heap[parent]){
                int temp=heap[current];
                heap[current]=heap[parent];
                heap[parent]=temp;
                current=parent;
            }
            else{
                break;
            }
        }
        size++;
    }
    
}
class insertIntoHeap {
    public static void main(String[] args) {
        System.out.println("Hello World in Java"); 
        SmallHeap h=new SmallHeap();
        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(55);
        h.insert(35);
        System.out.println(Arrays.toString(Arrays.copyOf(h.heap, h.size)));
    }
}
//Time complexity for inserting the node in heap is 
//O(log n)

//General points about heaps (considering 0 based indexing)
// to find the parent of the nodes it is (index-1/2)
//to find the left child of the parent node (2*index+1)
//to find the right child of the parent nodes (2*index+2)

//considering 1 1 based indexing
//to find the parent of the ndes if is(index/2)
//to find the left child of the parent node (2*index)
//to find the right child of the parent nodes (2*index+1)
