// https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=problem-list-v2&envId=string
class Solution {
public:
    bool isVowel(char ch){
        string vowels="aeiouAEIOU";
        return vowels.find(ch)!=string::npos;
    }
    string reverseVowels(string s) {
        int i=0;
        int j=s.size()-1;
        while(i<j){
            if(!isVowel(s[i])){
                i++;
            }
            else if(!isVowel(s[j])){
                j--;
            }
            else{
                char temp=s[i];
                s[i]=s[j];
                s[j]=temp;
                i++;
                j--;

            }
        }
        return s;
    }
};

//Agar character milta hai → uska index return hota hai.

// Agar nahi milta → string::npos return hota hai.

// string.find(ch) yaaa to first occurence (index) return arega yaa to npos return larega.