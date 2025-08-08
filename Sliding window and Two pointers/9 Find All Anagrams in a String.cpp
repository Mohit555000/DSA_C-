//https://www.youtube.com/watch?v=egPDpu26q0M
//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/?envType=problem-list-v2&envId=sliding-window

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
       vector<int> sCount(26,0);
       vector<int> pCount(26,0);
       vector<int> result;
       for(int i=0;i<p.size();i++){
        pCount[p[i]-'a']++;
       }
       for(int i=0;i<s.size();i++){
        sCount[s[i]-'a']++;

        if(i>=p.size()){
            sCount[s[i-p.size()]-'a']--;
        }

        if(sCount==pCount){
            result.push_back(i-p.size()+1);
        }
       }
       return result;
    }
};