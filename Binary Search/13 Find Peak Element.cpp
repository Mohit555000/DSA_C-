//https://leetcode.com/problems/find-peak-element/description/?envType=problem-list-v2&envId=binary-search
//https://www.youtube.com/watch?v=cXxmbemS6XM
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n=nums.size();
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int low=1, high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
};

// 🎯 Problem Definition
// The task is LeetCode “Find Peak Element” (one-dimensional). You’re given an array nums where adjacent elements are never equal. The goal is to find any peak element — one that’s strictly greater than its immediate neighbors — and return its index. The ends are treated as -∞ outside the array, making them potential peaks.

// 🧠 Intuition & Approach

// A binary search style is used to achieve O(log n) time complexity.

// Compare nums[mid] with nums[mid + 1]:

// If nums[mid] < nums[mid + 1], there's a rising slope to the right → a peak exists rightwards. So, move left = mid + 1.

// Otherwise (i.e., nums[mid] > nums[mid + 1]), the slope is flat or descending → a peak lies at or left of mid. Set right = mid.

// 🛠 Step-by-Step Example

// Initialize left = 0, right = n - 1.

// While left < right:

// Compute mid = (left + right) // 2.

// Check nums[mid] vs nums[mid + 1].

// Adjust pointers accordingly:

// If rising slope → left = mid + 1

// Else → right = mid

// Loop ends when left == right, which points to a peak.

// ✅ Why It Works

// Because anytime you see an ascent (nums[mid] < nums[mid + 1]), you know there must be a peak somewhere to the right.

// Otherwise, the peak is at or to the left of mid.

// This invariant guarantees we converge on a true peak.

// 📌 Complexity

// Time: O(log n) — thanks to binary search

// Space: O(1) — only a few pointers are used

// Let me know if you'd like a deeper dive into the proof or a code walk-through in a specific language!