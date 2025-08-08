//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//https://www.youtube.com/watch?v=-zSxTJkcdAo&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=3
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> hash(256,-1);
        int maxLen=0;
        int left=0, right=0;
        int n=s.size();
        int len=0;
        while(right<n){
            if(hash[s[right]]!=-1){
                if(hash[s[right]]>=left){
                    left=hash[s[right]]+1;
                }
            }
            len=right-left+1;
            maxLen=max(maxLen,len);
            hash[s[right]]=right;
            right++;
        }
        return maxLen;
    }
};