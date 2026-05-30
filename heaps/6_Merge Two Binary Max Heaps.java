//https://www.youtube.com/watch?v=_9F2VgZcvdw&list=PLWlla5Y-1FqyOqTat11CmcQp1nl079d0W&index=2
//https://www.naukri.com/code360/problems/merge-two-binary-max-heaps_1170049?leftPanelTabValue=PROBLEM

//Brute Force Appraoch
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> mergeHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        //  Write your code here...
        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr1.size();i++){
            pq.add(arr1.get(i));
        }
        for(int i=0;i<arr2.size();i++){
            pq.add(arr2.get(i));
        }
        while(!pq.isEmpty()){
            int currentElement=pq.poll();
            list.add(currentElement);
        }
        return list;
    }
}

//optimized Approach using the heapify algorithm
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static void heapify(ArrayList<Integer> merged,int totalElements,int parentIndex){
        int largestValueIndex=parentIndex;
        int leftChildIndex=(2*parentIndex)+1;
        int rightChildIndex=(2*parentIndex)+2;

        // 1. Check if the left child exists and is greater than our current largest
        if(leftChildIndex<totalElements && merged.get(leftChildIndex)>merged.get(largestValueIndex)){
            largestValueIndex=leftChildIndex;
        }
        // 2. Check if the right child exists and is greater than our current largest
        if(rightChildIndex<totalElements && merged.get(rightChildIndex)>merged.get(largestValueIndex)){
            largestValueIndex=rightChildIndex;
        }
        //// 3. If either child was larger than the parent, swap them!
        if(largestValueIndex!=parentIndex){
            int temp=merged.get(parentIndex);
            merged.set(parentIndex,merged.get(largestValueIndex));
            merged.set(largestValueIndex,temp);

            // Since we swapped, the child's subtree might be broken now.
            // Recursively pass the tracking down to the affected child's position.
            heapify(merged,totalElements,largestValueIndex);
        }

    } 
    public static void transformArrayIntoHeap(ArrayList<Integer> merged){
        //getting the total number of nodes in the list
        int totalElements=merged.size();
        //since leaf nodes are already in correct position
        int lastNonLeafIndex=(totalElements/2)-1;
        for(int i=lastNonLeafIndex;i>=0;i--){
            heapify(merged,totalElements,i);
        }

    }
    public static ArrayList<Integer> mergeHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        //  Write your code here...
        //step 1 merge two heaps
        ArrayList<Integer> merged=new ArrayList<>();
        for(int i =0;i<arr1.size();i++){
            merged.add(arr1.get(i));
        }
        for(int i=0;i<arr2.size();i++){
            merged.add(arr2.get(i));
        }

        //Step 2 build heap using the merged array
        transformArrayIntoHeap(merged);
        return merged;
    }
}
