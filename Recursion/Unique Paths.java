//It is a pattern of include or exclude
//https://leetcode.com/problems/unique-paths/description/?envType=problem-list-v2&envId=combinatorics

class Solution {
    public int solve(int row, int col, int m, int n){
        if(row>m-1 || col>n-1){
            return 0;
        }
        if(row==m-1 && col==n-1){
            return 1;
        }
        int right=solve(row,col+1,m,n);
        int down=solve(row+1,col,m,n);

        return right+down;
    }
    public int uniquePaths(int m, int n) {
        int ans=solve(0,0,m,n);
        return ans;
    }
}

✅ Hinglish Summary of Your Code

Yeh code robot ke unique paths count karta hai using pure recursion.
Robot sirf Right ya Down jaa sakta hai.
Hum (0,0) se start karte hai aur (m-1, n-1) tak pahunchne ki total possible ways return karte hai.
  🧠 Step-by-Step Explanation (Hinglish + Simple)
1. Base Case 1 → Out of Grid
  if(row > m-1 || col > n-1){
    return 0;
}

💡 Meaning:

Agar robot grid ke bahar chala gaya (invalid position),
toh 0 return karo.

❗Why return 0?

Kyuki grid ke bahar jaane ka koi valid path exist nahi karta.
Iska matlab:
"Yeh route bekaar hai → Is path se destination tak nahi jaa sakte."

  2. Base Case 2 → Destination Reached

  if(row == m-1 && col == n-1){
    return 1;
}

💡 Meaning:

Agar robot bottom-right corner par pahunch gaya hai →
toh yeh ek valid path complete ho chuka hai.

✔️ Why return 1?

Kyuki humne 1 valid unique path find kar liya hai.
Ab is path ko count karna necessary hai, isliye 1 return kiya jaata hai.

3. Recursive Calls → Right and Down Move
int right = solve(row, col+1, m, n);
int down  = solve(row+1, col, m, n);

💡 Meaning:

Robot ke paas do choices hoti hain:

Right jao → col + 1

Down jao → row + 1

Har move ek alag recursion call banata hai.

4. Combine the Results
  return right + down;

💡 Meaning:

Agar right side se X paths mil rahe hain
aur down side se Y paths mil rahe hain
→ Total = X + Y

✔️ Why add?

Kyuki dono direction alag-alag unique paths generate karti hain.

5. Starting the Recursion

return solve(0, 0, m, n);

Hum grid ke top-left se (0,0) se start karte hain.

📝 Short Recall Version (Use This for Revision)

(0,0) se start

Agar grid ke bahar gaye → return 0

Agar destination par pahunch gaye → return 1

Har step par:

Right jao

Down jao

Dono ke answers add kar do (right + down)

This is pure recursion counting all possible valid paths.
