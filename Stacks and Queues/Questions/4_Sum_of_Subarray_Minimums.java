//Method 1 (Brute Force Approach)
// formed all the subarrays and used min heap to fetch the min element from each of the sub array 
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n =arr.length;
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                PriorityQueue<Integer> minheap=new PriorityQueue();
                for(int k=i;k<=j;k++){
                    minheap.add(arr[k]);
                }
                result=result+minheap.poll();
            }
        }
        return result;
    }
}
