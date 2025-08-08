//https://www.youtube.com/watch?v=8QfC0elqK1o
//https://leetcode.com/problems/excel-sheet-column-title/?envType=problem-list-v2&envId=string
class Solution {
public:
    string convertToTitle(int columnNumber) {
        string result="";
        while(columnNumber>0){
            columnNumber--;
            int rem=columnNumber%26;
            result=result+(char)(rem+'A');
            columnNumber=columnNumber/26;
        }
        reverse(result.begin(),result.end());
        return result;
                       
    }
};

Problem samajh lo pehle
Excel sheet me columns ka naam hota hai:
1 → A  
2 → B  
...  
26 → Z  
27 → AA  
28 → AB  
...  


Kya dikkat hai?
Normal base-26 me digits 0–25 hote hain (jaise decimal me 0–9 hote hain).
Lekin Excel me A–Z ka matlab hota hai 1–26 (zero ka koi concept nahi hai).

Isliye jab hum calculation karte hain, hume pehle 1 minus karna padta hai (columnNumber--) taki mapping sahi aaye.

Approach Step-by-Step
Loop chalayenge jab tak columnNumber > 0.

Pehle columnNumber-- karenge (1-based ko 0-based me laane ke liye).

Remainder nikaalenge:

rem = columnNumber % 26

rem ko letter me convert karenge:

letter = 'A' + rem

Is letter ko result string me add karenge.

Column number ko 26 se divide karenge:
columnNumber /= 26

Loop khatam hone ke baad result ko reverse karenge (kyunki hum last se pehle build karte hain).

Example: columnNumber = 28

columnNumber = 28

Step 1: columnNumber-- → 27
        rem = 27 % 26 = 1 → 'B'
        result = "B"
        columnNumber = 27 / 26 = 1

Step 2: columnNumber-- → 0
        rem = 0 % 26 = 0 → 'A'
        result = "BA"
        columnNumber = 0

Reverse → "AB"
