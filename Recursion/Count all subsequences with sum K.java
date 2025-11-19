//https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k
//pattern - include and exclude
public class Solution {
    public int solve(int index,int[] arr,int k){
 
        if(k==0){
            return 1;
        }
 
        if(k<0){
            return 0;
        }
 
        if(index>=arr.Length){
            return 0;
        }
 
        int left = solve(index+1,arr,k-arr[index]);
        int right = solve(index+1,arr,k);
 
        return left + right;
    }
    public int CountSubsequenceWithTargetSum(int[] nums, int k) {
        return solve(0,nums,k);
    }
}


🔎 Short summary (Hinglish)

Yeh code given array nums (ya arr) ke subsequences check karta hai aur count karta hai kitni subsequences ka sum exactly k hota hai. Approach recursive include/exclude hai: har index par do choices — current element ko include karo ya skip karo — aur dono choices ke results ko add kar do.

🧩 Function-level explanation (Hinglish, step-by-step)

solve(index, arr, k) — iska kaam: index se starting subsequences me se kitne subsequences ka sum exactly k ho sakta hai.

1) Base case: if (k == 0) return 1;

Kya matlab?
Agar required sum k zero ho gaya hai, iska matlab ab tak jo elements humne include kiye unka sum original target k ko pura kar chuka hai.

Kyon return 1?
Kyuki ek valid subsequence mil chuki hai — jo abhi form ho chuki hai (including possibly empty set if originally k==0). Hum count kar rahe hain “1 valid way”.

2) Base case: if (k < 0) return 0;

Kya matlab?
Agar required sum negative ho gaya (humne already target se zyada add kar liya), to aage jaake sum wapas exactly k (jo ab negative hai) karaana impossible hoga assuming array me negative numbers nahi hain. (Agar array negative elements ho sakte hain to logic change hoga.)

Kyon return 0?
Kyuki is path se kool bhi valid subsequence nahi niklega — isliye count 0.

3) Base case: if (index >= arr.Length) return 0;

Kya matlab?
Hum array ke end tak aa gaye aur ab aur element consider karne ko nahi hai. Agar upar wala k==0 case trigger nahi hua (nahi mila), to matlab valid subsequence nahi mila.

Kyon return 0?
Kyuki remaining elements khatam ho chuke — aur agar k abhi 0 nahi hai to possible nahi hai. Isliye 0 valid ways.

4) Recursive choices (include / exclude)

int left = solve(index+1, arr, k - arr[index]); // include current
int right = solve(index+1, arr, k);              // exclude current

return left + right;

Kya ho raha hai?

left = current element include karne se kitne ways milte hain (isliye k - arr[index] pass karte hain).

right = current element skip karke kitne ways milte hain (k same rehta hai).
Total ways = dono choices ke valid ways ka sum.

Kyon add karte hain?
Kyuki include aur exclude mutually exclusive unique subsequences generate karte hain; dono ko combine karna hota hai.

🔁 Dry-run example (step-by-step)

Take nums = [1, 2, 3], k = 3.

Start: solve(0, [1,2,3], 3)

index 0 (val=1):

Include 1 → solve(1, [1,2,3], 2)

Exclude 1 → solve(1, [1,2,3], 3)

Evaluate solve(1, ..., 2):

index 1 (val=2):

Include 2 → solve(2, ..., 0) → k==0 → returns 1 (we found subsequence [1,2])

Exclude 2 → solve(2, ..., 2)

solve(2, ..., 2):

index 2 (val=3):

Include 3 → solve(3, ..., -1) → k<0 → returns 0

Exclude 3 → solve(3, ..., 2) → index>=len → returns 0

So solve(2, ..., 2) = 0 + 0 = 0

Thus solve(1, ..., 2) = 1 + 0 = 1

Now evaluate solve(1, ..., 3) (back to excluding 1 case):

index 1 (val=2):

Include 2 → solve(2, ..., 1)

Exclude 2 → solve(2, ..., 3)

solve(2, ..., 1):

index 2 (val=3):

Include 3 → solve(3, ..., -2) → 0

Exclude 3 → solve(3, ..., 1) → 0
→ 0

solve(2, ..., 3):

index 2 (val=3):

Include 3 → solve(3, ..., 0) → k==0 → 1 (subsequence [3])

Exclude 3 → solve(3, ..., 3) → 0
→ 1

So solve(1, ..., 3) = 0 + 1 = 1

Finally total = solve(0,...) = (include branch)1 + (exclude branch)1 = 2

Valid subsequences summing to 3: [1,2] and [3] → count = 2.

⚠️ Edge-cases / assumptions (important to remember)

Negative numbers in array:

Agar arr me negative numbers ho sakte hain, k < 0 ➜ return 0 rule galat ho sakta hai because negative numbers later add k wapas 0 tak laa sakte hain. Toh original logic assumes non-negative numbers.

Empty array & k == 0:

If nums empty aur k == 0, then solve(0, [], 0) → hits k==0 immediately → returns 1 (empty subsequence counts). Yeh expected behavior hai usually.

Index check syntax:

Tumhara code uses arr.Length (C# style). Agar yeh Java hai to use arr.length. (Bas ek quick note — agar multi-language confusion ho to adjust.)

⏱️ Complexity (short)

Time: O(2^n) worst-case (exponential) — kyunki har index do choices.

Space: O(n) recursion stack.

Tip: Agar large input, use memoization (DP) with key (index,k) to reduce to O(n * k).

📝 Quick Recall Cheat-sheet (copy-paste friendly)

k == 0 → return 1 (found a valid subsequence)

k < 0 → return 0 (overshot target; no valid subseq assuming non-negative nums)

index >= arr.length → return 0 (no more elements; if k!=0 then fail)

Else: return solve(index+1, k - arr[index]) + solve(index+1, k) (include + exclude)
