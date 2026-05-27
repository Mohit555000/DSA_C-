//https://youtu.be/NKJnHewiGdc?si=KSL1kfjXInGGi0KH
import java.util.Arrays;
class Main {
    public static void restoreHeapPropertyDown(int[] array, int totalElements, int parentIndex) {
        int largestValueIndex=parentIndex; //// Start by assuming the parent is the largest

        int leftChildIndex=(2*parentIndex)+1;
        int rightChildIndex=(2*parentIndex)+2;
        // 1. Check if the left child exists and is greater than our current largest
        if(leftChildIndex<totalElements && array[leftChildIndex]>array[parentIndex]){
            largestValueIndex=leftChildIndex;
        }
        // 2. Check if the right child exists and is greater than our current largest
        if(rightChildIndex<totalElements && array[rightChildIndex]>array[parentIndex]){
            largestValueIndex=rightChildIndex;
        }
        // 3. If either child was larger than the parent, swap them!
        if(largestValueIndex!=parentIndex){
            int tempSavedValue=array[parentIndex];
            array[parentIndex]=array[largestValueIndex];
            array[largestValueIndex]=tempSavedValue;

            // Since we swapped, the child's subtree might be broken now.
            // Recursively pass the tracking down to the affected child's position.
            restoreHeapPropertyDown(array,totalElements,largestValueIndex);
        }
    }
    public static void transformArrayToHeap(int[] array) {
        int totalElements = array.length;

        // Find the very last node in the array that actually has children (a non-leaf node)
        int lastNonLeafIndex = (totalElements / 2) - 1;

        // Loop backward from that last non-leaf node all the way up to the root (index 0)
        for (int i = lastNonLeafIndex; i >= 0; i--) {
            restoreHeapPropertyDown(array, totalElements, i);
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World in Java"); 
        int[] unsortedArray = {4, 10, 3, 5, 1};
        System.out.println("Unsorted Array:     " + Arrays.toString(unsortedArray));

        // Transform the array in-place
        transformArrayToHeap(unsortedArray);

        System.out.println("Max-Heapified Array: " + Arrays.toString(unsortedArray));
    }
}


//In a complete binary tree the leaf nodes start from (n/2)+1 till nth index where n is the toal number of nodes [in terms of tree] 
// or total number of elements [in terms of array]. so in this algortm we know that the lead nodes are already a heap we dont need to verify
// these nodes again they are already in their right place so I wont process the elements from (n/2)+1 till n. I will process from i=1 to n/2 
// process mtlb heap mai right position mai place kar na hota hai to jo algorithm hum use karenege usko he heapify bol te hai 
