//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/1652539232/?envType=problem-list-v2&envId=binary-search

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int start=0;
        int end=nums.size()-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]==target){
                return true;
            }
            if((nums[start]==nums[mid]) && (nums[mid]==nums[end])){
                start++;
                end--;
            }
            else if(nums[start]<=nums[mid]){
                if((nums[start]<=target) && (target<=nums[mid])){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if((nums[mid]<=target) && (target<=nums[end])){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return false;
    }
};


//🔍 Summary: Search in Rotated Sorted Array with Duplicates (Leetcode 81)
// Purpose:
// Search for a target value in a rotated sorted array that may contain duplicates. Returns true if the target is found, otherwise false.

// 🧠 Key Insight:
// This problem is a variant of the classic binary search in a rotated sorted array, but with duplicate elements, which makes it more complex. Duplicate values can make it hard to determine which part of the array is sorted, so an extra check is added.

// ⚙️ Logic Breakdown:
// Initialize pointers:
// start = 0, end = nums.size() - 1.

// Binary search loop:
// While start <= end:

// Calculate middle index: mid = start + (end - start) / 2.

// If nums[mid] == target: return true.

// Handle ambiguity with duplicates:

// If nums[start] == nums[mid] == nums[end], we can't determine the sorted half.
// So: increment start++ and decrement end-- to shrink the range.

// Left half is sorted:
// If nums[start] <= nums[mid]:

// If target lies between start and mid: search left half (end = mid - 1)

// Else: search right half (start = mid + 1)

// Right half is sorted (otherwise):

// If target lies between mid and end: search right half (start = mid + 1)

// Else: search left half (end = mid - 1)

// If the loop exits without finding the target, return false.

// ⏱ Time Complexity:
// Worst case: O(n)
// Due to duplicates causing linear-like behavior when nums[start] == nums[mid] == nums[end].

// Best case: O(log n)
// When there are no (or few) duplicates.

// 📦 Space Complexity:
// O(1) — constant extra space used.

// ✅ Return Value:
// true if target is found.

// false otherwise.

//  Context: Binary Search in Rotated Sorted Array with Duplicates
// In a normal rotated sorted array (without duplicates), we can always determine which half is sorted — either the left half or the right half — because the values are unique.

// But with duplicates, this becomes ambiguous.

// ⚠️ Problem: nums[start] == nums[mid] == nums[end]
// When the elements at the start, mid, and end are all equal, like:

// nums = [2, 2, 2, 3, 4, 2]
//          ↑        ↑     ↑
//        start     mid   end

//        It becomes impossible to determine which half of the array is sorted. Here’s why:

// Normally, we do:

// If nums[start] <= nums[mid]: left half is sorted

// Else: right half is sorted

// But if all three are equal:

// nums[start] == nums[mid] == nums[end]

// This gives no useful information about sorted order, because both halves could potentially contain the same repeated value.

// So we can’t decide whether to search the left or the right.

// ✅ Solution: Shrink the Search Space
// Since we can’t determine the sorted half, we reduce the ambiguity by shrinking the search space:

// start++;
// end--;
// This skips over the duplicates at the edges that are causing confusion, under the assumption that they don’t help determine sortedness and are not equal to the target (if they were, we would have returned true already).

// 🧪 Example
// nums = [2, 2, 2, 3, 2, 2, 2]
//          ↑           ↑     ↑
//        start        mid   end
// Suppose target = 3. We have:

// nums[start] == nums[mid] == nums[end] == 2

// Can't know which half is sorted

// So we do: start++, end--

// Now the new window is:

//        [2, 2, 3, 2, 2]
//          ↑     ↑
//        start  end
// Eventually, the ambiguity will disappear as you shrink the search window, and normal binary search can resume.

//  Why it’s Safe to Shrink
// Because you're only removing values equal to both ends and the middle:

// If they're not equal to the target, you lose nothing.

// If they are equal to the target, you’ll return true earlier (when nums[mid] == target).

// 📝 In Short:
// When nums[start] == nums[mid] == nums[end], binary search loses the ability to distinguish sorted halves. So, the safe and correct approach is:

// 🔁 Increment start++ and decrement end-- to skip duplicates and continue searching.

