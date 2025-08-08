// https://leetcode.com/problems/valid-perfect-square/description/?envType=problem-list-v2&envId=binary-search

class Solution {
public:
    bool isPerfectSquare(int num) {
        int start=0;
        int end=num;
        while(start<=end){
            long long mid=start+(end-start)/2;
            if(mid*mid==num){
                return true;
            }
            else if(mid*mid>num){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return false;
    }
};

//🚀 Approach: Binary Search
// Search Range:
// Start from 0 to num (because a square root can't be larger than the number itself).

// Mid Calculation:
// Use mid = start + (end - start) / 2 to avoid overflow.

// Check Condition:

// If mid * mid == num → it's a perfect square → return true.

// If mid * mid > num → move left → end = mid - 1

// If mid * mid < num → move right → start = mid + 1

// If the loop ends without finding an exact square, return false.

// ⚠️ Important:
// Use long long for mid to avoid integer overflow when doing mid * mid.

// ⏱️ Time Complexity:
// O(log n) — fast and efficient