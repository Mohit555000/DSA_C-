//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=problem-list-v2&envId=binary-search


class Solution {
public:
    int findFirst(vector<int>& nums, int target) {
        int start = 0, end = nums.size() - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    int findLast(vector<int>& nums, int target) {
        int start = 0, end = nums.size() - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return {first, last};
    }
};

// 🔍 Summary: Find First and Last Position of Element in Sorted Array
// Purpose:
// Given a sorted array nums, find the first and last positions of a target value using binary search. If the target is not found, return [-1, -1].

// ⚙️ Core Functions:
// 1. findFirst(nums, target):
// Performs binary search to find the first (leftmost) occurrence of target.

// If nums[mid] >= target, the target could be at mid or to the left, so move end = mid - 1.

// If nums[mid] < target, move start = mid + 1.

// If nums[mid] == target, store the index and keep searching left to find the first occurrence.

// 2. findLast(nums, target):
// Similar binary search to find the last (rightmost) occurrence.

// If nums[mid] <= target, the target could be at mid or to the right, so move start = mid + 1.

// If nums[mid] > target, move end = mid - 1.

// If nums[mid] == target, store the index and keep searching right to find the last occurrence.

// 3. searchRange(nums, target):
// Calls findFirst() and findLast() to get the range.

// Returns a vector {first, last} as the result.

// 🧠 Key Insight:
// Both first and last positions can be found independently using binary search with O(log n) time.

// Storing the index temporarily even after a match helps continue the search in the correct half.

// ⏱ Time Complexity:
// O(log n) for each binary search → total O(log n).

// 📦 Space Complexity:
// O(1) — only a few variables used.

// 📝 Return Value:
// A vector of two integers: [first_position, last_position]

// If target is not found, returns [-1, -1].

