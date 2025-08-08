// https://leetcode.com/problems/valid-parentheses/?envType=problem-list-v2&envId=string
class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(char ch:s){
            if(ch=='(' ||ch=='[' ||ch=='{'){
                st.push(ch);
            }
            else{
                if(st.empty()) return false;
                char top=st.top();
                if(ch==')' && top=='(' || ch==']' && top=='[' || ch=='}' && top=='{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            
        }
        return st.empty();
    }
};

// Stack ka use karte hain:

// Jab bhi koi opening bracket mile ((, {, [), toh usse stack me daal dete hain.

// Closing bracket milne par:

// Pehle check karte hain ki stack khali toh nahi (st.empty()).

// Agar khali hai → galat string → false return kar do.

// Agar nahi, toh stack ke top element ko check karte hain:

// Kya woh matching opening bracket hai?

// Agar haan → pop() kar do.

// Agar nahi → false return kar do.

// Last me:

// Agar stack poori tarah se empty ho gaya, matlab saare brackets sahi se match ho gaye → return true.

// Agar stack me kuch bacha hai, matlab kuch opening bracket close nahi hue → return false.