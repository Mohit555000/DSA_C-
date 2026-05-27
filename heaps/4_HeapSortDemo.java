//https://www.youtube.com/watch?v=NKJnHewiGdc&list=PLWlla5Y-1FqyOqTat11CmcQp1nl079d0W
import java.util.Arrays;

public class HeapSortDemo {

    /**
     * Fixes a single subtree down the line to restore the max-heap property.
     * Starts at the parentIndex and bubbles the element down if it's too small.
     */
    public static void restoreHeapPropertyDown(int[] array, int totalElements, int parentIndex) {
        int largestValueIndex = parentIndex; // Start by assuming the parent is the largest
        
        int leftChildIndex = (2 * parentIndex) + 1;
        int rightChildIndex = (2 * parentIndex) + 2;

        // 1. Check if the left child exists and is greater than our current largest
        if (leftChildIndex < totalElements && array[leftChildIndex] > array[largestValueIndex]) {
            largestValueIndex = leftChildIndex;
        }

        // 2. Check if the right child exists and is greater than our current largest
        if (rightChildIndex < totalElements && array[rightChildIndex] > array[largestValueIndex]) {
            largestValueIndex = rightChildIndex;
        }

        // 3. If either child was larger than the parent, swap them!
        if (largestValueIndex != parentIndex) {
            int temporarySavedValue = array[parentIndex];
            array[parentIndex] = array[largestValueIndex];
            array[largestValueIndex] = temporarySavedValue;

            // Recursively pass the tracking down to fix the affected child's subtree
            restoreHeapPropertyDown(array, totalElements, largestValueIndex);
        }
    }

    /**
     * The main Heap Sort function that sorts an array in ascending order.
     */
    public static void sortUnsortedArray(int[] array) {
        int totalElements = array.length;

        // STEP 1: Turn the raw random array into a valid Max-Heap
        int lastNonLeafIndex = (totalElements / 2) - 1;
        for (int i = lastNonLeafIndex; i >= 0; i--) {
            restoreHeapPropertyDown(array, totalElements, i);
        }

        // STEP 2: Sort the array by repeatedly shrinking the heap
        // We loop backward from the last element down to index 1
        for (int i = totalElements - 1; i > 0; i--) {
            
            // A. SWAP: Move the maximum element (always at index 0) to the current end slot 'i'
            int temporarySavedValue = array[0];
            array[0] = array[i];
            array[i] = temporarySavedValue;

            // B. SHRINK & HEAPIFY: Run heapify strictly at index 0.
            // By passing 'i' as the total elements argument, we shrink the active 
            // array size by 1, safely locking the swapped element into its final sorted position.
            restoreHeapPropertyDown(array, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] randomArray = {4, 10, 3, 5, 1};
        System.out.println("Original Unsorted Array: " + Arrays.toString(randomArray));

        // Sort the array in-place
        sortUnsortedArray(randomArray);

        System.out.println("Perfectly Sorted Array:  " + Arrays.toString(randomArray));
    }
}