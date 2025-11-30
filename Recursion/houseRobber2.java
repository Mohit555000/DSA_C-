//https://leetcode.com/problems/house-robber-ii/
class Solution {
    public int helper(int[] nums,int start,int end){
        if(start>end){
            return 0;
        }
        //we have to rob the house
        int option1=nums[start]+helper(nums,start+2,end);
        //we dont have to rob the house
        int option2=0+helper(nums,start+1,end);
        int ans=Math.max(option1,option2);
        return ans;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        //handling the single house case
        if(n==1){
            return nums[0];
        }
        int index=0;
        int option1=helper(nums,0,n-2);
        int option2=helper(nums,1,n-1);
        int ans=Math.max(option1,option2);
        return ans;
    }
}

// ✅ HOUSE ROBBER II — Hinglish Explanation (Your Code)

// 🔍 Problem Context (Hinglish)

// House Robber II mein ek twist hai:

// Houses straight line mein nahi hain.

// Balki circular arrangement mein hain.

// Matlab first house aur last house neighbors hote hain.

// ⚠️ Isliye first aur last house ko saath mein rob nahi kar sakte, warna alarm baj jayega.

// ✅ Your Approach Summary

// Aapne do cases consider kiye:

// 1️⃣ Case 1 → First house include karna allowed nahi → rob from index 0 to n-2
// 2️⃣ Case 2 → First house skip kar diya → rob from index 1 to n-1

// Finally dono ka max return.

// 👇 Step-by-step ZARA SIMPLE Hindi + English:
// ➤ Base Condition
// if (start > end) return 0;

// Agar hum valid houses se bahar chale gaye → aur paise nhi mil sakte.

// ➤ Option 1: Ye house rob karo

// Agar rob karte ho → next house skip karna padta hai.

// Isliye start + 2

// ➤ Option 2: Ye house skip karo

// Next house rob kar sakte ho → isliye start + 1

// Math.max(option1, option2)


// Jis choice se zyada paise → woh answer.

// 🏡 rob() Function Explanation
// public int rob(int[] nums) {
//     int n = nums.length;
//     if(n == 1){
//         return nums[0];
//     }

//     // Case 1: rob houses 0 to n-2
//     int option1 = helper(nums, 0, n - 2);

//     // Case 2: rob houses 1 to n-1
//     int option2 = helper(nums, 1, n - 1);

//     return Math.max(option1, option2);
// }


// 🤔 Why two cases? (Most important)

// Because first aur last ek saath rob nahi kar sakte.

// So:

// Case 1 → First house ko consider kiya

// Then last house must be excluded, so we only check 0 to n-2.

// Case 2 → First house skip kiya

// Then we can check 1 to n-1.

// ⭐ Final answer = max(option1, option2)

// 🆚 Difference Between House Robber 1 and House Robber 2
// 🔵 HOUSE ROBBER I

// ➤ Houses straight line mein hain

// Only one restriction:

// You cannot rob adjacent houses.


// Bas ek hi recursion hota hai:
// rob from index 0 to n-1


// No special case.

// 🔴 HOUSE ROBBER II
// ➤ Houses circle mein hain

// Extra restriction:

// 🔴 HOUSE ROBBER II
// ➤ Houses circle mein hain

// Extra restriction:
// Isliye solution split karna padta hai:

// Isliye solution split karna padta hai:

// Final = max of both cases.

// 🧠 Short Summary: House Robber 1 vs House Robber 2
// | Feature                        | House Robber I  | House Robber II              |
// | ------------------------------ | --------------- | ---------------------------- |
// | Arrangement                    | Linear          | Circular                     |
// | Can rob first & last together? | Yes             | ❌ No                         |
// | Number of DP/Recursive calls   | 1               | 2 (two scenarios)            |
// | Logic                          | Simple rob/skip | rob/skip but in two segments |
