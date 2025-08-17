//https://leetcode.com/problems/find-the-difference/?envType=problem-list-v2&envId=string
class Solution {
public:
    char findTheDifference(string s, string t) {
        char ch;
        int freq[26]={0};
        for(auto ch:t){
            freq[ch-'a']++;
        }
        for(auto ch:s){
            freq[ch-'a']--;
        }
        for(int i=0;i<t.size();i++){
            if(freq[t[i]-'a']>0){
                ch=t[i];
            }
        }
        return ch;
    }
};