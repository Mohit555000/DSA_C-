class houseRobber {
    public int solve(int[] nums,int index,int size){
        //base condition (if no house is left)
        if(index>=size){
            return 0;
        }
        //we have to rob the house
        int option1=nums[index]+solve(nums,index+2,size);
        //we don't rob the house
        int option2=0+solve(nums,index+1,size);

        int ans=Math.max(option1,option2);

        return ans;
    }
    public int rob(int[] nums) {
        int size=nums.length;
        int index=0;
        int ans=solve(nums,index,size);
        return ans;
    }
}

// ✅ Hinglish Explanation — House Robber (Your Code Logic)

// Is problem mein ek row mein houses diye hain, aur har house mein kuch paisa rakha hai.
// Agar aap kisi house ko rob karte ho, toh uske neighbour (index + 1) wale house ko rob nahi kar sakte — warna alarm baj jayega.

// Isliye har index (house) par do choices hoti hain:

// 1️⃣ Choice 1: Rob the current house

// Agar hum current house index ko rob karte hain:

// Hume uska amount mil jayega → nums[index]

// Next house rob nahi kar sakte
// → isliye aage directly index + 2 se solve karna padega.

// Code mein:
// int option1 = nums[index] + solve(nums, index + 2, size);

// 👉 Yaha +2 isliye kiya, kyunki agar current house rob kar diya, toh next neighbour house ko skip karna mandatory hai.

// 2️⃣ Choice 2: Skip the current house

// Agar hum current house ko rob nahi karte:

// Koi paise nahi milte now (0)

// Next house (index + 1) free hoga… use rob kar sakte ho.

// Code mein:
// int option2 = solve(nums, index + 1, size);

// 👉 Yaha +1 isliye kiya, kyunki humne current house skip kiya aur ab next house par jaa rahe hain.

// 3️⃣ Best choice choose karna

// Dono options ka max lete ho:

// int ans = Math.max(option1, option2);

// Yeh batata hai ki kis choice se zyada paise mil rahe hain.

// 4️⃣ Base condition
// if(index >= size) return 0;

// Agar saare houses check ho chuke → 0 return (no money left to rob).

// 5️⃣ Final call in rob()
// Starting index = 0 se shuru karte ho:
// int ans = solve(nums, index, size);


// ⭐ Final Summary (1-liner style)

// +2 because: agar house rob kiya toh neighbour ko rob nahi kar sakte.

// +1 because: agar house skip kiya toh next house (index + 1) check karna hai.

// Dono choices ka maximum answer final result hota hai.