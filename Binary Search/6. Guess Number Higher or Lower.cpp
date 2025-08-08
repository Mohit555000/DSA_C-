// https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=problem-list-v2&envId=binary-search
class Solution {
public:
    int guessNumber(int n) {
        int start = 1, end = n;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);  // Only call once
            
            if (result == 0) {
                return mid;
            } else if (result == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1; // Should never reach here if input is valid
    }
};

// ✅ Summary: Guess Number Higher or Lower (Binary Search)
// 🎯 Goal:
// Guess a number between 1 and n using the guess(int num) API, which tells you if your guess is:

// -1 → Too high

// 1 → Too low

// 0 → Correct guess

// 🔍 Approach: Binary Search
// Start with the full range: start = 1, end = n

// In each step:

// Calculate mid = start + (end - start) / 2

// Call guess(mid) once and store the result

// If the result is:

// 0 → You found the number → return mid

// -1 → The number is smaller → search left → end = mid - 1

// 1 → The number is larger → search right → start = mid + 1

// If the loop ends, return -1 (just as a fallback — normally won't be needed)

// ⚠️ Optimization Highlight:
// Call guess(mid) only once per iteration to avoid unnecessary repeated API calls.

// ⏱️ Time Complexity:
// O(log n) — very efficient!

