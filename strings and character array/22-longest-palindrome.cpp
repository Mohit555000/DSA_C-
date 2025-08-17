// https://leetcode.com/problems/longest-palindrome/description/?envType=problem-list-v2&envId=string


// 🔑 Problem Samajh

// Hume ek string di gayi hai, aur hume longest palindrome banana hai uske letters se.

// Palindrome matlab forward aur backward same hota hai.

// Rule simple hai:

// Characters ke pairs (even frequency) easily left-right me place ho jate hain.

// Sirf ek character odd frequency ka allowed hai jo center me baith sakta hai.

// 🧠 Intuition (sochne ka tarika)

// Har character ka frequency count karo.

// Agar frequency even hai → pura use kar lo.

// Agar frequency odd hai → (freq - 1) le lo (jo even part hoga), aur mark kar lo ki ek odd bacha hai.

// Last me agar koi odd frequency mila tha → +1 add kar dena (jo center me baith jayega).


// 📝 Dry Run Example

// s = "abccccdd"

// Counts → {a:1, b:1, c:4, d:2}

// Process:

// a=1 → (1-1)=0 use, ek odd hai.

// b=1 → (1-1)=0 use, ek aur odd hai.

// c=4 → 4 use kar liya.

// d=2 → 2 use kar liya.

// Total = 4 + 2 = 6
// Odd exist karta hai → +1
// 👉 Answer = 7


// ✅ Logic ka formula
// sum of (even parts of all counts) + (agar odd mila to +1)

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> freq;
        //step 1 frequency count
        for(auto ch:s){
            freq[ch]++;
        }
        int length=0;
        bool isOdd=false;
        //step 2 use even part of counts
        for(auto [ch,count]:freq){
            if(count%2==0){
                length=length+count; //even pura use ho gaya
            }
            else{
                count=count-1;
                length=length+count; //odd ka even part use ho gaya
                isOdd=true; //ek odd bacha hai 
            }
        }
        //agar koi odd mila tha to +1 kar na hai 
        
        if(isOdd){
            length=length+1;
        }
        return length;

    }
};