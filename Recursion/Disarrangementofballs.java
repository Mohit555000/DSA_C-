//https://www.geeksforgeeks.org/problems/dearrangement-of-balls0918/1
// User function Template for Java

class Solution {
    static int countDer(int n) {
        // Base case
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        int ans=(n-1)*(countDer(n-1)+countDer(n-2));
        return ans;
        
    }
}


// ⭐ Goal

// D(n) = number of ways to arrange n balls such that no ball goes to its original basket.

// ⭐ Recurrence Relation
// D(n) = (n - 1) * (D(n-1) + D(n-2))


// Ab isko zero intuition se samjhte hain.

// 🎯 Step-by-Step Hinglish Explanation

// Consider ball 1.
// Ball 1 cannot go to basket 1.

// So ball 1 ke paas n – 1 choices hain:

// Ball 1 → basket k  
// (k ≠ 1)


// Let’s pick one such basket k.

// Now 2 possibilities are created for ball k:

// ✅ Case 1: Ball k goes to basket 1

// Ball 1 ne basket k liya.
// Ball k ne basket 1 liya.

// This is like a swap of 1 and k.

// Remaining balls = n - 2
// Unke derangements = D(n - 2)

// ✅ Case 2: Ball k does NOT go to basket 1

// Agar ball k basket 1 nahi leता, to:

// Basket 1 abhi bhi empty hai

// Ball k ko bhi apna original basket nahi lene dena

// Baaki balls including ball k = n - 1

// Now effectively we derange:

// n - 1 balls


// So number of ways = D(n - 1)

// ⭐ Combining both cases

// For the chosen basket k:

// Total derangements =

// D(n - 1) + D(n - 2)


// But ball 1 ke paas (n - 1) choices the basket choose karne ke.

// So final multiplication:

// (n - 1) * (D(n - 1) + D(n - 2))


// And that is exactly our recurrence.

// 📌 Very Small Example (n = 3)

// Balls: {1,2,3}

// Step 1: Ball 1 cannot go to basket 1 → choices = {2,3}

// So (n − 1) = 2 choices.

// ➤ Case 1: Ball 1 → Basket 2

// Then ball 2 has two cases:

// Ball 2 → Basket 1 → leaves ball 3 (D(1) = 0)

// Ball 2 → NOT basket 1 → derange remaining 2 balls (D(2) = 1)

// Total = 1

// ➤ Case 2: Ball 1 → Basket 3

// Exactly same logic → gives 1

// Final answer for n=3 = 2

// And recurrence gives:

// D(3) = (3-1) × (D(2) + D(1))
//      = 2 × (1 + 0)
//      = 2


// Perfect match ✔️

// 🎯 Summary (Super Simple)

// Imagine ball 1 picks some wrong basket k:

// 1️⃣ Ball k → basket 1 → swap → use D(n-2)
// 2️⃣ Ball k → not basket 1 → treat as derangements of n-1 balls → D(n-1)

// Multiply by the n - 1 possible k choices.

// That’s the whole recurrence.