//https://leetcode.com/problems/generate-parentheses/description/?envType=problem-list-v2&envId=backtracking
//https://www.youtube.com/watch?v=WW1rYrR3tTI
class Solution {
    public void help(int n,List<String> ans,int open,int close,StringBuilder current_string){
        //base condition
        if(current_string.length()==2*n){
            ans.add(current_string.toString());
            return;
        }
        //add "("
        if(open<n){
            current_string.append("(");
            help(n,ans,open+1,close,current_string);
            current_string.deleteCharAt(current_string.length() - 1);//backtracking;
        }
        //add ")"
        if(close<open){
            current_string.append(")");
            help(n,ans,open,close+1,current_string);
            current_string.deleteCharAt(current_string.length() - 1);//backtracking
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int close=0;
        int open=0;
        StringBuilder current_string=new StringBuilder();
        help(n,ans,open,close,current_string);
        return ans;
    }
}

//aaise smj ke kar na hai ki jo n hai vo pairs nhi hai, n mtlb muje kitne opening aur kitne closing bracket allowed hai laga na/
🧠 FULL SUMMARY (Generate Parentheses — Code + Concept Explanation)
1️⃣ n ka matlab kya hota hai?

n = kitne pairs of brackets allow hain.

Iska matlab:

Tum n baar '(' use kar sakte ho.

Tum n baar ')' use kar sakte ho.

Example:

n = 2 → (( )) → total 4 characters

n = 3 → ((())) → total 6 characters

So:

Total final string length = 2 * n

2️⃣ Recursion ka core idea

Har step par tumhare paas do choices hoti hain:

✔ Choice 1: '(' add karo

Condition:

open < n


Kyuki opening brackets max n hi ho sakte hain.

✔ Choice 2: ')' add karo

Condition:

close < open


Kyuki closing brackets kabhi opening se zyada nahi ho sakte.

3️⃣ Base Condition (MOST IMPORTANT)

Base condition sirf ek hoti hai:

if (current.length() == 2 * n)
    ans.add(current)
    return

Tum isko aise samajh sakte ho:

Tum maximum n opening + n closing = 2n characters bana sakte ho.

Jab tumhari string exactly 2*n characters ho jaye,
iska matlab tumne required number of brackets use kar liye.

Ab aur add nahi kar sakte → recursion stop.

Example:

n = 2 → base condition: length == 4

n = 3 → base condition: length == 6

4️⃣ Backtracking Logic (StringBuilder Version)

Hum:

ek char add karte hain,

recursive call karte hain,

phir woh char remove karte hain (backtracking).

Code part:

cur.append(ch);
backtrack(...);
cur.deleteCharAt(cur.length() - 1);


Iska purpose:

Har branch ek fresh state se chale

Previous attempts ka string disturb na ho

5️⃣ Final Valid Strings Kaise Bante Hain?

n = 2 example:

Possible valid strings:

(())
()()


Ye isliye valid hain kyunki:

'(' ka count = n

')' ka count = n

Kisi bhi point par ')' > '(' nahi hota

6️⃣ Code Summary (in words)

Function backtrack run hota hai.

Jab tak tumhare paas '(' bachaa hai → tum '(' add kar sakte ho.

Jab tak closing count < opening count → tum ')' add kar sakte ho.

Jab string ki length 2*n ho jaye → usko answer me daal do.

Backtracking se string wapas previous state me aa jati hai.

Sab branches explore karke final answer ban jaata hai.
