//https://leetcode.com/problems/reverse-string/description/


// --Method 1

class Solution {
public:
    void reverseString(vector<char>& s) {
        int i=0;
        int j=s.size()-1;
        char temp;
        while(i<=j){
            swap(s[i],s[j]);
            i++;
            j--;
        }
    }
};



// --method 2

class Solution {
public:
    void reverseString(vector<char>& s) {
        int i=0;
        int j=s.size()-1;
            while(i<=j){
            char ch=s[i];
            s[i]=s[j];
            s[j]=ch;
            i++;
            j--;
        }
    }
};