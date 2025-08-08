// https://www.youtube.com/watch?v=_eNhaDCr6P0&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&ab_channel=takeUforward

// https://leetcode.com/problems/longest-repeating-character-replacement/
class Solution {
public:
    int characterReplacement(string s, int k) {
        int l=0;
        int r=0;
        int maxLen=0;
        int maxFreq=0;
        vector<int> hash(26,0);
        while(r<s.size()){
            hash[s[r]-'A']++;
            maxFreq=max(maxFreq,hash[s[r]-'A']);

            if((r-l+1)-maxFreq>k){
                hash[s[l]-'A']--;
                maxFreq=0;
                l=l+1;
            }
            if((r-l+1)-maxFreq<=k){
                maxLen=max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
};