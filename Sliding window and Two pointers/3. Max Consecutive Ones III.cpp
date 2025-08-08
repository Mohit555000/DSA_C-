//https://www.youtube.com/watch?v=3E4JBHSLpYk&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=4
//https://leetcode.com/problems/max-consecutive-ones-iii/
class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int left=0, right=0;
        int maxLen=0;
        int zeros=0;
        int length=0;
        while(right<nums.size()){
            if(nums[right]==0){
                zeros++;
            }
            if(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            if(zeros<=k){
                length=right-left+1;
                maxLen=max(length,maxLen);
            }  
            right++; 
        }
        return maxLen;
    }
};

// 📌 Purpose:
// Is function ka goal hai:

// "Longest subarray ka length nikalna jisme maximum k zeroes ko 1 samajh ke treat kiya jaa sakta hai."

// Matlab, tum k tak zeroes ko flip kar sakte ho, aur dekhna hai longest continuous 1s ka length kitna ban sakta hai.

// 🧠 Logic Samjho:
// Sliding window approach use kiya gaya hai (left aur right pointers).

// zeros variable count karta hai kitne 0 abhi tak mile window ke andar.

// Agar zeros > k ho jaye, to left pointer ko aage badha ke window chhoti karni padti hai, taaki condition satisfy ho jaaye.

// Jab bhi zeros <= k ho, to current window ka length calculate karke maxLen update karte hain.

// ⚙️ Step-by-Step Flow:
// right pointer array ke end tak chalta hai.

// Agar nums[right] == 0, to zeros++ (0 mila, toh count badhao).

// Agar zeros > k, to left ko aage le jao jab tak zeros <= k ho jaaye.

// Har bar jab zeros <= k, to window ka length nikaalo (right - left + 1) aur maxLen update karo.

// End me maxLen return kar do.

// 📌 Variables Ka Role:
// Variable	Meaning
// left	Sliding window ka start
// right	Sliding window ka end
// zeros	Window ke andar abhi tak ke 0s ka count
// maxLen	Sabse bada valid window (answer)
// length	Current valid window ka length