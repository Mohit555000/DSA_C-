//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

class Solution {
public:
    string removeDuplicates(string s) {
        string ans="";
        int index=0;
        while(index<s.length()){
            //same
            //right most character of ans and current character of strting s are same
            if(ans.length()>0 && ans[ans.length()-1]==s[index]){
                ans.pop_back();
            }
            //different
            //right most character of ans and current character of strting s are different
            else{
                ans.push_back(s[index]);
            }
            index++;
        }
        return ans;
    }
};