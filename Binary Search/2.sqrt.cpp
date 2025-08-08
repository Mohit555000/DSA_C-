// https://leetcode.com/problems/sqrtx/description/?envType=problem-list-v2&envId=binary-search

class Solution {
public:
    int mySqrt(int x) {
        int start = 0;
        int end = x;
        int res = 0; // initialize res to 0
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long long square = 1LL * mid * mid; // prevent overflow
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
};

// 🧠 Notes: Finding Integer Square Root using Binary Search
// 🔍 Goal:
// Find the integer part of the square root of a non-negative number x
// (i.e., the largest integer r such that r * r <= x).

// 💡 Why Use Binary Search?
// The function n * n is monotonically increasing, so binary search fits well.

// Faster than brute force: from O(n) to O(log x).

// Efficient for large inputs.

// 📌 How Binary Search Works:
// Start with: start = 0, end = x

// ✅ Why end = x?
// Because √x is always in the range [0, x].
// Even though it’s usually less than x, starting with x guarantees we don’t miss any possible answer.

// (Optional optimization: use end = x / 2 for x ≥ 2 for a slightly smaller range.)

// Find the middle: mid = (start + end) / 2

// Check:

// If mid * mid == x, return mid

// If mid * mid < x, move right → start = mid + 1, and store mid as a possible result

// If mid * mid > x, move left → end = mid - 1

// When the loop ends, return res (the best found integer square root)

// ⚠️ Prevent Integer Overflow:
// Use long long or 1LL * mid * mid when calculating mid * mid

// This avoids overflow for large values like mid = 46341

// ✅ Time & Space Complexity:
// Time: O(log x)

// Space: O(1)