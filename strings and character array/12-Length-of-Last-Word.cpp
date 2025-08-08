//https://leetcode.com/problems/length-of-last-word/?envType=problem-list-v2&envId=string
// https://www.youtube.com/watch?v=pLhSigp5rjI

class Solution {
public:
    int lengthOfLastWord(string s) {
        int count=0;
        int i=s.size()-1;
        while(s[i]==' '){
            i--;
        }
        while(i>=0 && s[i]!=' '){
            count++;
            i--;
        }
        return count;
    }
};