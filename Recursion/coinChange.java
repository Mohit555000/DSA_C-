//https://leetcode.com/problems/coin-change/submissions/1831513633/
//refer love babbar 
class Solution {
    public int solve(int[] coins,int amount){
        if(amount==0){
            return 0;
        }
        int mini=Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int coin=coins[i];
            if(coin<=amount){
                int recursiveAns=solve(coins,amount-coin);
                if(recursiveAns!=Integer.MAX_VALUE){
                    ans=1+recursiveAns;
                }
            }
            mini=Math.min(mini,ans);
        }
        return mini;
    }
    public int coinChange(int[] coins, int amount) {
        int ans=solve(coins,amount);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return ans;
        }
    }
}


// ✅ Hinglish Summary — Coin Change (Recursive Approach Without DP)
// 1) Problem Goal

// amount ko banane ke liye minimum number of coins chahiye.
// Agar bana hi nahi sakte → -1 return karo.

// 🚀 Kaise Kaam Karta Hai (Logic Flow)
// 1. Base Case
// if(amount == 0) return 0;


// Agar amount 0 ho gaya → koi coin nahi chahiye → answer = 0.

// 2. Har coin try karo

// Loop chalta hai:

// Coin uthao → coin = coins[i]

// Agar coin ≤ amount:

// Recursively pucho:

// recursiveAns = solve(amount - coin)


// Agar recursiveAns valid ho:

// ans = 1 + recursiveAns

// 3. Har baar minimum value update karna
// mini = Math.min(mini, ans);


// Isse sab coins ko try karke minimum coins wale answer ko store kar lete ho.

// 4. Final result return
// return mini;

// 🎯 Final Output

// coinChange() function:

// Recursion se ans lata hai

// Agar ans Integer.MAX_VALUE hai → iska matlab amount nahi ban sakta → return -1

// Warna minimum coins return karta hai

//This is explore all the options. technique refer love babbar lecture 32.

