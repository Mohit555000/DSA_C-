// https://leetcode.com/problems/valid-palindrome/
class Solution {
public:
    bool isPalindrome(string s) {
        if(s.size()==0){
            return true;
        }
        int i=0;
        int j=s.size()-1;
        while((i<=j)&&(!isalnum(s[i])) || (!isalnum(s[j]))){
            if(tolower(s[i])!=tolower(s[j]) return false;
            i++;
            j--;
        }
        return true;
    }
};