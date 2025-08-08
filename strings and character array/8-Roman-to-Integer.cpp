//https://leetcode.com/problems/roman-to-integer/?envType=problem-list-v2&envId=string
//https://www.youtube.com/watch?v=9JvtUFO5RvE
class Solution {
public:
    int romanToInt(string s) {
        map<char,int> m;
        m.insert({'I',1});
        m.insert({'V',5});
        m.insert({'X',10});
        m.insert({'L',50});
        m.insert({'C',100});
        m.insert({'D',500});
        m.insert({'M',1000});

        int ans=0;
        for(int i=0;i<s.size();i++){
            if(i==s.size()-1){
                ans=ans+m[s[i]];
            }
            else if(m[s[i]]>=m[s[i+1]]){
                ans=ans+m[s[i]];
            }
            else{
                ans=ans-m[s[i]];
            }
        }
        return ans;
    }
};

Map banana – Sabhi Roman characters (I, V, X, L, C, D, M) aur unki values ko ek map mein store kiya gaya hai.

Loop chalana – String ke har character pe loop chal raha hai.

Logic:

Agar current character last character hai, toh uski value seedha ans mein add karo.

Agar current character ki value next character se zyada ya barabar hai, toh add karo.

Agar current character ki value kam hai next character se, toh subtract karo (jaise IV = 5 - 1 = 4).

Return – Final ans return kiya jata hai jo ki converted integer hota hai.

Example:
"IX" → I < X → 10 - 1 = 9

Yeh approach Roman numeral ke subtraction rule ko dhyan mein rakh kar likhi gayi hai.