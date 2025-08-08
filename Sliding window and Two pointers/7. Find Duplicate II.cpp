//https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=sliding-window
class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        set<int> arr;
        int left=0;
        int right=0;
        while(right<nums.size()){
            if(right-left>k){
                arr.erase(nums[left]);
                left=left+1;
            }
            if(arr.contains(nums[right])){
                return true;
            }
            arr.insert(nums[right]);
            right++;
        }
        return false;
    }
};