//https://leetcode.com/problems/combination-sum/description/
//https://www.youtube.com/watch?v=jkgZw2WEaqA
class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public void helper(List<List<Integer>> ans,List<Integer> combination,int index,int[] candidates,int target){
        if(index==candidates.length || target<0){
            return;
        }
        if(target==0){
            if(!set.contains(combination)){
                set.add(new ArrayList<>(combination));
                ans.add(new ArrayList<>(combination));
            }
            
            return;
        }

        combination.add(candidates[index]);
        //Now three calls will be called.
        //1) element will be added in the combination list only once (Inclusion)
        helper(ans,combination,index+1,candidates,target-candidates[index]);
        //2) element will be added in the combination list multiple times i.e same element is added multiple times therefore we are not increasing the index (Inclusion)
        helper(ans,combination,index,candidates,target-candidates[index]);
        // Now before the exclusion call. we have to back track i.e remove the elemnt which was added last.
        combination.remove(combination.size()-1);
        //3) element will not be added in the combination list  (exclusion)
        helper(ans,combination,index+1,candidates,target);
        


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        helper(ans,combination,0,candidates,target);
        return ans;
    }
}




Summary - 
  🔹 Hinglish Summary of Your Code

Tumne Combination Sum problem solve karne ke liye recursion + backtracking use kiya hai.
Har step pe tum ek candidate number ko handle kar rahe ho aur decide kar rahe ho:

Usko ek baar lena hai?

Usko multiple times lena hai? (kyunki same number unlimited baar le sakte ho)

Ya usko bilkul nahi lena?

Saath hi tumne Set<List<Integer>> use kiya hai taaki duplicate combinations avoid ho jaayein.

🔹 Why 3 Recursive Calls? (Intuition Simple Language mein)

Yeh problem mein tumhare paas har number ko use karne ke 3 choices hain:

1) Take Once → helper(ans, combination, index+1, candidates, target - candidates[index])

Is call me tum current element ek baar lete ho,

phir next index pe move karte ho.

Iska matlab aage future me ye number dobara nahi lenge from this path.

👉 Useful when you want to take candidate only once.

2) Take Multiple Times → helper(ans, combination, index, candidates, target - candidates[index])

Yaha tum same index pe hi rukte ho.

Kyunki Combination Sum me same element unlimited baar allowed hai.

Har baar target reduce hota rahega but index same rahega.

👉 Useful jab tum soch rahe ho "ye number mujhe dobara bhi chahiye".

3) Don't Take the Element (Exclusion) → helper(ans, combination, index+1, candidates, target)

Yeh call represent karta hai ki tum iss element ko bilkul ignore kar rahe ho.

Aur directly next index pe jaa rahe ho.

👉 Useful jab tum decide karte ho: "mujhe yeh number nahi chahiye".

🔹 Big Picture Intuition

💡 Tum har number ke liye teen paths explore karte ho:

Decision	Matlab
Take once	Ek baar leke aage badho
Take multiple times	Same number ko fir se consider karo
Skip	Use ignore karo

Isliye 3 recursive calls lagti hain.

Backtracking ka kaam:
Combination list me jo add kiya tha, wo recursion ke baad remove kar dena, taaki next path clean slate se start ho.

🔹 In Short:

Your approach explores all possible ways of using each element:

0 times

1 time

Many times

Aur fir har valid combination (target = 0) ko result me add kar deta hai.
