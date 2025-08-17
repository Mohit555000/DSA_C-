//https://leetcode.com/problems/is-subsequence/?envType=problem-list-v2&envId=string
class Solution {
public:
    bool isSubsequence(string s, string t) {
        int last=t.size()-1;
        stack<char> st;
        for(auto ch:s){
            st.push(ch);
        }
        while(last>=0 && !st.empty()){
            if(st.top()==t[last]){
                st.pop();
            }
            last--;
        }
        if(st.empty()){
            return true;
        }
        else{
            return false;
        }
        
    }
};

// stack approach (samajhna easy way mein)

// Pehle s ke sare characters ko stack mein daal diya.

// Matlab last character top pe hoga.

// Fir t ko end se traverse karna start kiya.

// Agar stack ke top aur t ka current character match kare → pop kar do.

// Nahi toh bas aage badho.

// Agar end mein stack empty ho gaya → iska matlab s ke sare characters match ho gaye in order → return true.
// Agar stack mein kuch bacha → matlab subsequence nahi mila → return false.