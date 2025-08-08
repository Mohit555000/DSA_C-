// https://leetcode.com/problems/running-sum-of-1d-array/


// Brute force approach
class Solution {
    public:
        vector<int> runningSum(vector<int>& nums) {
            int n = nums.size();
            vector<int> runningSum(n,0);
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=0;j<=i;j++){
                    sum=sum+nums[j];
                }
                runningSum[i]=sum;
            }
            return runningSum;
        }
    };

    we are calculating the sum again and again for each index

Time complexity is O(n^2)
space complexity is O(n)


// better approach 

class Solution {
    public:
        vector<int> runningSum(vector<int>& nums) {
            int n = nums.size();
            vector<int> runningSum(n,0);
            runningSum[0]=nums[0];
            for(int i=1;i<n;i++){
                runningSum[i]=runningSum[i-1]+nums[i];
            }
            return runningSum;
        }
    };
Use previosuly calculated running sum and use that 
time complexity is O(n) and space complexity is O(n)

//best approach

class Solution {
    public:
        vector<int> runningSum(vector<int>& nums) {
            for (int i = 1; i < nums.size(); ++i) {
                nums[i] += nums[i - 1];
            }
            return nums;
        }
    };
Time complexity is O(n) and space complexity is O(1)    


