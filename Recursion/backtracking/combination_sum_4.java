//https://leetcode.com/problems/combination-sum-ii/

class Solution {

    Set<List<Integer>> set = new HashSet<>();

    public void helper(int[] candidates, List<List<Integer>> ans,
                       List<Integer> combination, int index, int target) {

        if (target == 0) {
            List<Integer> temp = new ArrayList<>(combination);
            Collections.sort(temp);         // sort to avoid duplicate structure
            if (!set.contains(temp)) {
                set.add(temp);
                ans.add(temp);
            }
            return;
        }

        if (target < 0 || index == candidates.length) return;

        // INCLUDE
        combination.add(candidates[index]);
        helper(candidates, ans, combination, index + 1, target - candidates[index]);
        combination.remove(combination.size() - 1); // BACKTRACK

        // EXCLUDE
        helper(candidates, ans, combination, index + 1, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        helper(candidates, ans, combination, 0, target);
        return ans;
    }
}

🚀 High-Level Intuition (Hinglish Me Samjho)

Ye problem subset generation jaisa hai.

Har element ke paas sirf do choices hoti hain:

1️⃣ Include karo → us element ko combination me add kar do
2️⃣ Exclude karo → us element ko skip kar do

Aur ye recursion har index ke liye hota hai.

Isko bolte hai:
✔ Include/Exclude pattern
✔ OR Subset recursion tree

Hum saare combinations generate karte hain.
Fir jab target == 0 hota hai, matlab ek valid combination mil gayi.

But duplicates ho sakte hain (same numbers, different positions).
Isliye Set use kar rahe ho aur list ko sort kar rahe ho.

🧠 Step-by-Step Hinglish Explanation
1. Base Case — target == 0
if (target == 0) {
    List<Integer> temp = new ArrayList<>(combination);
    Collections.sort(temp);
    if (!set.contains(temp)) {
        set.add(temp);
        ans.add(temp);
    }
    return;
}

Hinglish Explain:

Agar target 0 ho gaya → matlab jo numbers combination me hai unka sum exactly target ke equal hai.

Yeh valid answer hai → so usko store kar do.

But:

candidates array sorted nahi hai.

Isliye same combination different order me aa sakta hai.

Example:

[1,2,5]  
[2,1,5]
[5,2,1]


Combination to same hai, par order alag-alag.

Isliye hum temp ko sort karte hain, taki format same ho jaye.

Phir Set me check — agar pehle stored nahi hai, tab hi add karte ho.

Intuition:

Sort + Set = duplicates control.

2. Invalid Case — target < 0 or index end ho gaya
if (target < 0 || index == candidates.length) return;

Hinglish Explain:

Agar target negative ho gaya → aage jaane ka koi fayda nahi (sum already zyada ho gaya).

Agar index last tak pahunch gaya → aur consider karne ke liye kuch bacha hi nahi.

To seedha return.

3. Include the current element
combination.add(candidates[index]);
helper(candidates, ans, combination, index + 1, target - candidates[index]);
combination.remove(combination.size() - 1);

Hinglish Explain:

Pehli choice: element ko include karo

Uska value target se minus karo

Next index pe jao

Backtrack: jo add kiya tha usko wapas nikal do

Intuition:

Ek branch me hum assume karte hain ki yeh number hum use kar rahe hain.

4. Exclude the current element
helper(candidates, ans, combination, index + 1, target);

Hinglish Explain:

Dusri choice: element ko skip kar do

Target same rahega

Bas next number check karo

Intuition:

Dusri branch me hum assume karte hain ki yeh number hum use Nahi kar rahe.

⚙️ Overall Recursion Tree Intuition

For each number:

              index
              /    \
      include        exclude


Har index pe 2 branches hoti hain.
Saare subsets check hote hain.
Jo subsets target ko equal karte hain → answer me add ho jaate hain.

🧠 Why Set is Needed?

Because array sorted nahi hai

Recursive traversal se same combination different order me ban sakti hai

Sorting makes order fixed

Set avoids duplicates

This works perfectly with the approach you want to follow.

📌 Final Hinglish Summary

Har element ke paas do hi choices hoti hain → include ya exclude.

Include → list me add karo aur target kam karo.

Exclude → index badhao aur target same rakho.

Jab target 0 ho jaye → valid combination mil gayi.

Sorting + Set use karke duplicates hatao.

Backtracking se list ko clean rakho.
