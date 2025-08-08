// https://leetcode.com/problems/build-array-from-permutation

class Solution {
    public:
        vector<int> buildArray(vector<int>& nums) {
            vector<int> ans(nums.size(),0);
            for(int i=0;i<=nums.size()-1;i++){
                ans[i]=nums[nums[i]];
            }
            return ans;
        }
    };

// The above apprach is a brute force approach just create a new vector and return it 


class Solution {
    public:
        vector<int> buildArray(vector<int>& nums) {
            int n = nums.size(); // correct size
            for (int i = 0; i < n; ++i) {
                nums[i] = nums[i] + (nums[nums[i]] % n) * n;   //nums[nums[i]] % n will give old value
            }
            for (int i = 0; i < n; ++i) {
                nums[i] = nums[i] / n;   // will give the new value.
            }
            return nums;
        }
    };

    The above approach is the approach for the follow up question that is to use O(1) space complexity

    // 1. Why We Use This Approach
    // ❓ The problem:
    // You're given an array nums which is a zero-based permutation (i.e., all numbers from 0 to n - 1 appear exactly once), and you’re asked to construct:
    

    // ans[i] = nums[nums[i]];
    // But you want to do this in-place — i.e., without using extra space.
    
    // 🚫 Naive Approach (uses space):

    // vector<int> ans(nums.size());
    // for (int i = 0; i < nums.size(); ++i) {
    //     ans[i] = nums[nums[i]];
    // }
    // return ans;
    // This uses O(n) extra space, which is not allowed in the follow-up.
    
    // ✅ Goal:
    // Perform the transformation in-place with O(1) extra space.
    
    // 🧠 The challenge:
    // You want to overwrite nums[i] with nums[nums[i]], but:
    
    // As soon as you change nums[i], you lose the original value.
    
    // The original value is needed to access nums[nums[i]] for later iterations.
    
    // 💡 The trick:
    // Store both the original and new values at the same index using arithmetic.
    
    // cpp
    // Copy
    // Edit
    // nums[i] = old_value + new_value * n;
    // Later, you can get:
    
    // new_value = nums[i] / n
    
    // old_value = nums[i] % n
    
    // ✅ This works because both old_value and new_value are < n.
    
    // 🔍 2. What Problem This Solves
    // This trick solves a common class of problems where you must:
    
    // Transform an array in-place
    
    // But need to preserve the original values to compute the result
    
    // It works because:
    
    // The range of numbers is bounded (between 0 and n-1)
    
    // You can use those bounds to "compress" two values into one
    
    // 🧭 3. How to Recognize Similar Patterns
    // Look for these signs:
    
    // Sign	What it Means
    // 🔄 You need to transform a list using values from itself	Risk of overwriting needed data
    // 🔒 You must do it in-place with O(1) extra space	No room for an extra array
    // 📏 All values are integers in a small, known range (e.g. 0 to n-1)	Allows for arithmetic encoding
    // 📉 Modulo or division appear in sample solutions	Suggests storing multiple things in one number
    
    // When you see a problem that involves:
    
    // Rearranging elements
    
    // Mapping indexes to values
    
    // Avoiding extra memory
    
    // → Ask: Can I encode two values into one using math?