//https://leetcode.com/problems/isomorphic-strings/?envType=problem-list-v2&envId=string

class Solution {
public:
    void createMapping(string& s){
            char start='a';
            char mapping[300]={0};
            //find the mapping
            for(auto ch:s){
                if(mapping[ch]==0){
                    mapping[ch]=start;
                    start++;
                }
            }
            //update the original string
            for(int i=0;i<s.length();i++){
                char ch=s[i];
                s[i]=mapping[ch];
            }
    }
    bool isIsomorphic(string s, string t) {
        //first normalize the pattern
        createMapping(s);
        createMapping(t);
        if(s==t){
            return true;
        }
        else{
            return false;
        }
    }
};


1. Problem ko simple language me samjho
Isomorphic ka matlab hai:

Tum ek string ke har character ko consistently replace karke dusri string bana sako.

Ek character sirf ek hi character me map ho sakta hai.

Mapping one-to-one honi chahiye, matlab:

s ka koi char → t ka ek fixed char

Aur t ka char → s ka ek fixed char

2. Tumhara approach ka main idea → "Pattern Normalization"
Instead of directly mapping s → t:

Dono strings ko ek common pattern me convert karo.

Fir compare karo.

Agar patterns same → strings isomorphic.

Example:

s = "paper"  → normalize → "abacd"  
t = "title"  → normalize → "abacd"  
Same pattern → ✅ Isomorphic.

3. Normalization ka step-by-step logic
Function: createMapping(string &s)

Step 1: Ek mapping array banao

char mapping[300] = {0};
char start = 'a';
mapping[ch] batayega ki original char ch ko kaunsa normalized char dena hai.

start batayega agla available normalized char (pehle 'a', fir 'b', fir 'c'...)

Step 2: Pehli pass → Mapping create karna

for (auto ch : s) {
    if (mapping[ch] == 0) {   // agar char ka mapping nahi banaya
        mapping[ch] = start;  // naya mapping assign karo
        start++;              // agle char ka mapping ready karo
    }
}
Is loop me hum unique characters ko order wise 'a', 'b', 'c'... assign kar rahe hain.

Example ("paper"):
'p' → 'a'
'a' → 'b'
'e' → 'c'
'r' → 'd'

Step 3: Dusra pass → Original string ko update karna
for (int i = 0; i < s.length(); i++) {
    s[i] = mapping[s[i]];
}
Har char ko uske mapped normalized char me replace kar do.

"paper" → "abacd"

4. Main function isIsomorphic
bool isIsomorphic(string s, string t) {
    createMapping(s); // normalize s
    createMapping(t); // normalize t
    return s == t;    // agar pattern same hai to true
}

5. Dry Run: "egg" and "add"
Normalize "egg":

'e' → 'a'
'g' → 'b'
"egg" → "abb"

Normalize "add":

'a' → 'a'
'd' → 'b'
"add" → "abb"

Compare: "abb" == "abb" → ✅ true

6. Kyun yaad rahega ye method
💡 Yaad rakhne ka trick:
"Har string ko ek universal language me translate karo, phir compare karo."

Isme:

mapping[] → dictionary jaisa kaam karta hai

Pehla loop → dictionary fill karta hai

Dusra loop → dictionary apply karta hai

Compare → bas same pattern check

7. Complexity
Time → O(n) (dono loops total)

Space → O(1) (mapping array fixed size 300, ASCII ke liye kaafi)

