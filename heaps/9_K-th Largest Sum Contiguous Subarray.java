//https://www.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1
//https://www.youtube.com/watch?v=eccAKrmffh8&list=PLWlla5Y-1FqyOqTat11CmcQp1nl079d0W&index=3

Brute Force Approach TC O(n^2 log(n))
  class Solution {
    public static int kthLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum=sum+arr[j];
                list.add(sum);
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list.get(k-1);
    }
}
Optimized is remaining
  
