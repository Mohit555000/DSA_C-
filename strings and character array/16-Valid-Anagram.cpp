//https://leetcode.com/problems/valid-anagram/?envType=problem-list-v2&envId=string
lass Solution {
public:
    bool isAnagram(string s, string t) {
        int freq[26]={0};
        for(auto ch:s){
                freq[ch-'a']++;
        }
        for(auto ch:t){
                freq[ch-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
};