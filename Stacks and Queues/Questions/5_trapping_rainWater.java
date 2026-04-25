https://www.youtube.com/watch?v=1_5VuquLbXg
//brute force approach
//TC - O(2n)
//SC - O(2n)
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] suffixMax=new int[n];
        int[] prefixMax=new int[n];
        int total=0;
        int leftMax=0;
        int rightMax=0;
        //prefixMax
        prefixMax[0]=height[0];
        for(int i=1;i<n-1;i++){
            prefixMax[i]=Math.max(prefixMax[i-1],height[i]);
        }
        //suffixMax
        suffixMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i]=Math.max(suffixMax[i+1],height[i]);
        }
        System.out.println("Prefix Sum-->"+Arrays.toString(prefixMax));
        System.out.println("Suffix Sum-->"+Arrays.toString(suffixMax));
        for(int i=0;i<n;i++){
            leftMax=prefixMax[i];
            rightMax=suffixMax[i];
            if(height[i]<leftMax&&height[i]<rightMax){
                total=total+(Math.min(leftMax,rightMax)-height[i]);
            }
        }
        
        return total;
    }
}
//optimized approach
SC - O(1)
TC - O(n)
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    total += leftMax - height[left];
                }
                left++;  // ❗ important
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    total += rightMax - height[right];
                }
                right--;  // ❗ important
            }
        }
        return total;
    }
}
