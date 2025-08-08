https://leetcode.com/problems/missing-number/description/?envType=problem-list-v2&envId=binary-search
//Method 1 if the array is not sorted
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int sum2 = 0;
        int sum = 0;

        for (int i = 0; i <= n; i++) { // should go up to n
            sum2 += i;
        }

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return sum2 - sum;
    }
};

//time complexity is o(n)
//Method 2 if array is sorted
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end()); // O(n log n)
        
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left; // the missing number
    };
};
//Time complexity is (o n logn )