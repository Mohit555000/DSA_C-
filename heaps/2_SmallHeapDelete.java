//https://youtu.be/NKJnHewiGdc?si=KSL1kfjXInGGi0KH
import java.util.Arrays;

public class SmallHeapDelete {
    private int[] heap = {8, 10, 3, 2, 5, 0, 0, 0, 0}; // Pre-filled max-heap
    private int size = 5; // Number of active elements

    public int extractMax() {
        if (size == 0) return -1; // Heap is empty

        int maxVal = heap[0]; // Save root to return
        
        // Step 1: Replace root with the last active element
        heap[0] = heap[size - 1]; 
        size--; // Logically remove the last element

        // Step 2: Heapify down (Bubble down)
        int current = 0;
        while (true) {
            int left = 2 * current + 1;
            int right = 2 * current + 2;
            int largest = current;

            // Find if left or right child is larger than current node
            if (left < size && heap[left] > heap[largest]) largest = left;
            if (right < size && heap[right] > heap[largest]) largest = right;

            // If a child is larger, swap and keep moving down
            if (largest != current) {
                int temp = heap[current];
                heap[current] = heap[largest];
                heap[largest] = temp;

                current = largest; 
            } else {
                break; // Node is in its correct place, stop
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        SmallHeapDelete h = new SmallHeapDelete();
        
        System.out.println("Before: " + Arrays.toString(Arrays.copyOf(h.heap, h.size)));
        
        int removed = h.extractMax();
        
        System.out.println("Removed: " + removed);
        System.out.println("After:  " + Arrays.toString(Arrays.copyOf(h.heap, h.size)));
    }
}


// Time complexity is O(log n)