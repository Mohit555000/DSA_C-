//https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
//https://www.youtube.com/watch?v=eccAKrmffh8&list=PLWlla5Y-1FqyOqTat11CmcQp1nl079d0W&index=3


Brute Force Approach
  class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n =mat.length;
        int m = mat[0].length;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.add(mat[i][j]);
            }
        }
        while(!pq.isEmpty()){
            int element=pq.poll();
            list.add(element);
        }
        return list;
    }
}

//optimized Approach

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> result=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        
        //// Step 1: Initialize the stream by adding the 1st element of every row
        for(int i=0;i<n;i++){
            if(m>0){
                pq.add(new int[]{mat[i][0],i,0});
                
            }
        }
        
        // Step 2: Stream through the elements "just-in-time"
        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int val=current[0];
            int row=current[1];
            int col=current[2];
            
            // Add the current smallest element to the final list
            result.add(val);
            // Step 3: Advance the pointer for the stream we just pulled from
            // If that row has a next element, stream it into the heap
            if(col+1<m){
                pq.add(new int[]{mat[row][col+1],row,col+1});
            }
        }
        return result;
        
        
    }
}


Here is the detailed breakdown of both Time Complexity and Space Complexity for your Brute Force and Optimized solutions to the "Merge K Sorted Arrays" problem.Let:$n$ = Number of rows in the matrix (mat.length)$m$ = Number of columns in each row (mat[0].length)$K = n \times m$ (The total number of elements in the entire matrix)1. Brute Force ApproachIn your Brute Force code, you push all elements into a single large Min-Heap and then empty the heap into a list.Time Complexity: $O(K \log K)$Insertion Phase: You loop through all rows ($n$) and columns ($m$), iterating exactly $K$ times. Inserting each element into a heap containing up to $K$ elements takes $O(\log K)$ time.$$\text{Total Insertion Time} = O(K \log K)$$Extraction Phase: The while loop runs $K$ times to empty the queue. Popping (poll()) an element from a heap of size $K$ takes $O(\log K)$ time.$$\text{Total Extraction Time} = O(K \log K)$$Overall Time: $O(K \log K) + O(K \log K) = \mathbf{O(K \log K)}$ (or $O(nm \log(nm))$).Space Complexity: $O(K)$You allocate memory for the PriorityQueue, which grows continuously until it stores all elements at once.Overall Space: $\mathbf{O(K)}$ (or $O(nm))$ to hold all values in the heap.2. Optimized Approach (Stream-based / K-Way Merge)In this approach, you utilize the fact that each row is already sorted. Instead of dumping everything into memory, you maintain a rolling window of front-runners—meaning the heap size is capped at exactly $n$ elements (one from each row).Time Complexity: $O(K \log n)$Initialization Phase: The first for loop runs $n$ times to insert the very first element of each row. Since the heap grows up to size $n$, this step takes $O(n \log n)$ time.Streaming Phase: The while loop processes every single element in the matrix exactly once, meaning it executes $K$ times. In each iteration, you do a poll() and a conditional add(). Because the heap never exceeds size $n$, these heap operations take a maximum of $O(\log n)$ time.$$\text{Streaming Time} = O(K \log n)$$Overall Time: $O(n \log n) + O(K \log n) = \mathbf{O(K \log n)}$ (or $O(nm \log n))$.Space Complexity: $O(n)$The PriorityQueue only holds the current active element from each stream. At any given microsecond, it will contain at most $n$ integer arrays (one element representing each row).Overall Space: $\mathbf{O(n)}$ auxiliary space for the heap. (Note: The final result list requires $O(K)$ space, but that is needed to store the output and is not considered extra/auxiliary space).Summary ComparisonMetricBrute ForceOptimized ApproachWhy the Optimization WinsTime Complexity$O(K \log K)$$O(K \log n)$Capping the heap size at $n$ instead of $K$ makes every insertion/deletion significantly faster ($\log n \ll \log K$).Space Complexity$O(K)$$O(n)$Memory usage scales linearly only with the number of rows ($n$) rather than the total elements ($K$).
