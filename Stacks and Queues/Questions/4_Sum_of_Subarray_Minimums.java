//Method 1 (Brute Force Approach) (good)
// formed all the subarrays and used min heap to fetch the min element from each of the sub array 
// It will give TLE
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


//Method 2 (Optimized Approach) (better)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n =arr.length;
        int result=0;
        int modulo=1000000007;
        for(int i=0;i<n;i++){
            int min=arr[i];
            for(int j=i;j<n;j++){
                min=Math.min(min,arr[j]);
                result=(result+min)%modulo;
            }
        }
        return result;
    }
}
