// https://leetcode.com/problems/concatenation-of-array/description/


method 1 using two loops 
class Solution {
    public:
        vector<int> getConcatenation(vector<int>& nums) {
            int n = nums.size();
            vector<int> ans(2*n,0);
            for(int i=0;i<n;i++){
                ans[i]=nums[i];
            }
            int j=n;
            int i=0;
            while(j<ans.size()&&i<nums.size()){
                ans[j]=nums[i];
                j++;
                i++;
            }
            return ans;
    
        }
    };



method 2
using one single loop

class Solution {
    public:
        vector<int> getConcatenation(vector<int>& nums) {
            int n = nums.size();
            vector<int> ans(2 * n);
            for (int i = 0; i < n; ++i) {
                ans[i] = nums[i];
                ans[i + n] = nums[i];  // copy again at the second half
            }
            return ans;
        }
    };
    