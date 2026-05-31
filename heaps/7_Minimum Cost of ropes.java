//https://www.youtube.com/watch?v=_9F2VgZcvdw&t=2923s
//https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
//this is the brute for approach with TC = O(n log n) 
//breakdown tc for adding elements into queue will take O(n log n) and for adding and polling from queue
// will take another O(n log n) so final tc = 2*O(n logn)=O(n logn)

// Optimized appraoch if i use the heapify algorithm (refer Q3) the time complexity will reamin the same so use same
class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int num:arr){
            pq.add(num);
        }
        int finalSum=0;
        while(pq.size()>1){
            int sum=0;
            int firstElement=pq.poll();
            int secondElement=pq.poll();
            sum=firstElement+secondElement;
            finalSum=finalSum+sum;
            pq.add(sum);
        }
        return finalSum;
        
    }
}
