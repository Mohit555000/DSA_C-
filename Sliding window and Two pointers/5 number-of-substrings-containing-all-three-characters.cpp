// <!-- https://www.youtube.com/watch?v=iSf7d2ldp70&ab_channel=NeetCodeIO -->
// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
class Solution {
public:
    int numberOfSubstrings(string s) {
        int n = s.length();
        int count = 0;
        int left = 0;
        unordered_map<char, int> freq;

        for (int right = 0; right < n; ++right) {
            freq[s[right]]++;

            // shrink the window from the left as long as we have all three characters
            while (freq['a'] > 0 && freq['b'] > 0 && freq['c'] > 0) {
                // all substrings from left to right are valid and can be extended till end
                count += (n - right); 
                freq[s[left]]--;
                left++;
            }
        }

        return count;
    }
};

// 💡 Optimized Approach – Sliding Window (O(n))
// Do pointers use karte hain: left aur right

// Ek frequency map banate hain jisme 'a', 'b', 'c' ka count track karte hain

// Jab tak current window me teeno characters mil jaye:

// count += (n - right);

// Yeh isliye kyunki right ke baad jitne bhi characters hain, un sab ke saath bhi valid substring banega

// Fir left pointer ko aage badhake window chhoti karte hain


// Significance of count += (n - right);
// Jab current window valid hai (teeno chars hain),
// toh us window ke end right se lekar string ke end tak saare substrings valid hote hain

// Example:
// Agar right = 2 hai aur string ka length n = 6,
// to valid substrings = s[left..2], s[left..3], ..., s[left..5] → total 6 - 2 = 4

