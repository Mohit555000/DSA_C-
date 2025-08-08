// https://leetcode.com/problems/excel-sheet-column-number/?envType=problem-list-v2&envId=string
class Solution {
public:
    int titleToNumber(string columnTitle) {
        long long result = 0; // final answer store karega
        
        for (char ch : columnTitle) { 
            // har character ko left se right read karenge
            
            int val = ch - 'A' + 1; 
            // ch - 'A' => distance from 'A'
            // +1 => kyunki 'A' ka matlab 1 hai Excel me
            
            result = result * 26 + val;
            // base-26 conversion logic
            // pehle se jo result bana hai usko 26 times bigger karo
            // fir current character ka value add karo
        }
        
        return result; // final column number
    }
};

Step-by-step Example: "AB"
Initial:
result = 0

Loop 1: ch = 'A'
val = 'A' - 'A' + 1 = 0 + 1 = 1
result = result * 26 + val
       = 0 * 26 + 1
       = 1

Loop 2: ch = 'B'
val = 'B' - 'A' + 1 = 1 + 1 = 2
result = result * 26 + val
       = 1 * 26 + 2
       = 28

Loop ends

return 28
✅ "AB" → 28

Ye code bas yeh kaam kar raha hai ki Excel ke letters ko base-26 number samajh ke normal integer me convert kar raha hai.
result = result * 26 + val → bilkul waise jaise decimal me result = result * 10 + digit hota hai.

