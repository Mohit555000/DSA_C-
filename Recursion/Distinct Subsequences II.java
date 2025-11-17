//https://leetcode.com/problems/distinct-subsequences-ii/
class Solution {
    public void solve(String s, String output, int index,Set<String> result) {
        

        if (index == s.length()) {
            if (!output.isEmpty())
                result.add(output);
            return ;
        }

        // Exclude current char
        solve(s, output, index + 1,result);

        // Include current char
        solve(s, output + s.charAt(index), index + 1,result);

       
        return;
    }

    public int distinctSubseqII(String s) {
        Set<String> result = new HashSet<>();
        solve(s, "", 0,result);
        return result.size();
    }
}
Step-by-step Hinglish summary (simple & clear)
1) Problem kya hai

Given a string s, humein distinct non-empty subsequences count karne hain.
Subsequence = original se kuch characters hata ke bacha hua sequence (order preserved).

  2) Jo code tune likha — idea kya hai (short)

Code recursion se include / exclude approach use karta hai:

Har index pe do choices: current character ko include karo, ya exclude karo.

Jab index string ke end tak pahunch jata hai, jo ban raha hai (output) agar empty nahi hai toh result set me add karo.

Set automatically duplicates hata dega — isliye final size = distinct subsequences.

  3) Code ka step-by-step walkthrough (line by line, simple)

distinctSubseqII(String s)

result naam ka HashSet<String> banaya (distinct store karne ke liye).

solve(s, "", 0, result) call kiya — recursion start.

solve(String s, String output, int index, Set<String> result)

Base case: if (index == s.length())

Agar output empty nahi hai to result.add(output); phir return.

Recursive case:

solve(s, output, index+1, result) → exclude current char (skip it).

solve(s, output + s.charAt(index), index+1, result) → include current char (append and go).

Phir return — recursion naturally backtracks.

  4) Example trace (quick) — s = "aba"

Start: output = "", index = 0 ('a')

Exclude 'a' → explore subsequences from "ba"

Include 'a' → output = "a", explore "ba"

Eventually set result me add honge (non-empty): "b", "a", "ab", "ba", "aa", "aba" — total 6 (duplicates removed automatically).

  5) Why Set use kiya?

Set duplicates eliminate karta hai — same subsequence alag paths se mil sakta hai (especially repeated chars), Set ensure unique values hi count ho.


  6) Complexity (important)

Time: O(2ⁿ) worst-case — kyunki har character ke liye 2 choices.

Space: O(n) recursion depth + O(number_of_distinct_subsequences * average_length) for storing strings in set.
→ Is approach se chhote inputs pe fine hai, lekin large strings (e.g., n up to 2000 on LeetCode) pe impossible / TLE / memory blow up.

  7) Practical note / suggestion (brevity)

Ye recursive approach sahi aur samajhne ke liye best hai — debugging aur learning ke liye perfect.

Production / LeetCode ke liye optimized DP chahiye: classic O(n) DP using dp[i] = 2*dp[i-1] - dp[lastOccurOfChar - 1] (modulo), jahan lastOccurOfChar recent index store hota hai.

DP se time O(n) aur space O(n) (ya O(1) optimized) milta hai.

  8) One-line summary (Hinglish)

Recursion se har index pe include/exclude karke sab subsequences generate karo, non-empty ones HashSet me add karo — result size distinct subsequences dega; lekin large inputs ke liye DP use karna better hai.
