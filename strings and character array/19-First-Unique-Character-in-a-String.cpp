//https://leetcode.com/problems/first-unique-character-in-a-string/?envType=problem-list-v2&envId=string

class Solution {
public:
    int firstUniqChar(string s) {
        int freq[26]={0};
        for(auto ch:s){
            freq[ch-'a']++;
        }
        for(int i=0;i<s.size();i++){
            if(freq[s[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
};

// 1 Har character ka count nikal lo (kyunki sirf lowercase letters hai → freq[26] array le sakte ho).

// 2 String me phir se iterate karke check karo, jo pehla character ka count 1 hoga wahi answer hai.


// 🔹 Dry Run Example

// s = "loveleetcode"

// Count:

// l=1, o=2, v=1, e=4, t=1, c=1, d=1

// Iterate:

// s[0] = 'l' → freq['l']=1 → return 0 ✅