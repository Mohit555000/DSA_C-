//https://www.interviewbit.com/problems/path-to-given-node/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public boolean helper(TreeNode A, int B,ArrayList<Integer> list){
        if(A==null){
            return false;
        }
        list.add(A.val);
        
        if(A.val==B){
            return true;
        }
        if(helper(A.left,B,list)|| helper(A.right,B,list)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
        
    }
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> list=new ArrayList<>();
        helper(A,  B,list);
        int[] ans=new int[list.size()];
        for(int i =0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}


📝 Concept: Recursion with Boolean Signal (Early Exit)Jab bhi humein kisi structure (Tree/Graph/Matrix) mein koi ek cheez ya rasta dhundna hota hai, toh hum boolean recursion ka use karte hain.1. Boolean Kyun Use Karein?Signal dene ke liye: Ye parent ko batata hai ki "Target mil gaya hai, ab maze se rasta freeze kar do."Stop karne ke liye: Jaise hi true milta hai, recursion baaki branches ko check karna band kar deta hai (Short-circuiting).2. Implementation Rule (The Golden Pattern)Hamesha ye 3 steps follow karo:Step A (Add): Current node ko list mein dalo.Step B (Check & Signal):Agar target mil gaya $\rightarrow$ return true.Agar niche (Left/Right) se true signal aaya $\rightarrow$ return true.Step C (Backtrack): Agar upar dono se true nahi mila, iska matlab rasta galat hai $\rightarrow$ List se node ko Remove karo aur return false bhej do.

3. Kab Use Karein?RequirementReturn TypeActionOnly 1 Path/ResultbooleanStop as soon as found.All Possible PathsvoidKeep searching everywhere.4. Cheat Code LogicJavaif (find(left) || find(right)) { 
    return true; // Ek bhi jagah mil gaya toh stop!
}
path.remove(); // Nahi mila toh rasta saaf karo.
return false;
