//https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=binary-search
//https://www.youtube.com/watch?v=5qGrJbHhqFs
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start=0;
        int end=nums.size()-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[start]<=nums[mid]){
                if((nums[start]<=target)&&(target<=nums[mid])){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if((nums[mid]<=target)&&(target<=nums[end])){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
};

// 🔍 Summary: Rotated Sorted Array Search (Binary Search)
// Purpose:
// Search for a target value in a rotated sorted array (nums) using a modified binary search. Returns the index of the target if found, otherwise returns -1.

// 🧠 Core Idea:
// The array is sorted but rotated at some unknown pivot (e.g., [4,5,6,7,0,1,2]).

// Perform a binary search while identifying which half of the array is sorted at each step.

// Use that information to decide whether to search the left half or the right half.

// ⚙️ Logic Breakdown:
// Initialize start = 0, end = nums.size() - 1.

// While start <= end:

// Calculate mid = start + (end - start) / 2 (to avoid overflow).

// If nums[mid] == target: return mid.

// Check if left half is sorted: nums[start] <= nums[mid]

// If target lies in the left half: move end = mid - 1.

// Else: search in the right half, start = mid + 1.

// Else, right half must be sorted:

// If target lies in the right half: move start = mid + 1.

// Else: search in the left half, end = mid - 1.

// 📦 Time Complexity:
// O(log n) — classic binary search performance.

// ✅ Space Complexity:
// O(1) — constant space usage.

