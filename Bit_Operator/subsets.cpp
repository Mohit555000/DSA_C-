class Solution {
    public:
        vector<vector<int>> subsets(vector<int>& nums) {
            int n=nums.size();
            vector<vector<int>> result;
            for(int i=0;i<pow(2,n);i++){
                vector<int> v;
                for(int j=0;j<n;j++){
                    if((1<<j)&i){
                        v.push_back(nums[j]);
                    }
                    
                }
                result.push_back(v);
            }
            return result;
        }
    };

// appraoch
// so first we need to find how many number of subsets are possible,
// so if the there are 3 elemets so total number of subsets are 2^n subsets
// for eg [1,2,3] total number of subsets will be 8 ([],[1],[1,2],[1,3],[2],[2,3],[3],[1,2,3])
// now we get the total number of possible subsets i.e 2^n (n=size of the given subset)

// no the trick is if the binary representation of the number ranging from 0 to 2^n, if the binary representation contains a set bit (i.e if the bit is 1)
// so we will consider that bit as an index and will fetch the element from the given arry which is located in that given array 
// for example
// 0 -> 000 -> we wont take anything from the given array since all are zero -> []
// 1 -> 001 -> we will take the 3rd element from the gievn array nums[2] -> [3]
// 2 -> 010 -> we will take the 2nd element from the gievn array nums[1] -> [2]
// 3 -> 011 -> we will take the 2nd and 3rd element from the gievn array nums[1] and nums[2] -> [2,3] 
// 4 -> 100 -> we will take the 1st element from the gievn array nums[0] -> [1]
// 5 -> 101 -> we will take the 1st and 3rd element from the gievn array nums[0] and nums[2] -> [1,3]
// 6 -> 110 -> we will take the 1st and 2nd element from the gievn array nums[0] and nums [1] -> [1,2]
// 7 -> 111 -> we will take all the elemnts from the given array nums[0], nums[1] and nums[2] -> [1,2,3]
// note - [],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3] these are the exact same subsets which we want.


// so in short if the binary representation consist 1 in for the range 0 to 2^n then we will consider that as index and fetch the number at that position in the given ARRAY


// why we are doing this (1<<j) & i


// i = 001 and j =0
// so we are left shifting 1 by 0 to create a mast and doing bitwise & with i 

// so i =001
//  & j =  1
// -----------
//         001 so consider the third elemnt and push it into the v vector





// //----------------------
// 📝 Subsets Using Bitmasking – Explanation
// 🔹 Problem:
// Generate all possible subsets (the power set) of a given array nums.

// 🔹 Key Insight:
// A set with n elements has exactly 
// 2
// 𝑛
// 2 
// n
//   subsets.

// Each subset can be represented by a binary number of length n.

// Each bit (0 or 1) in the binary number determines whether to include (1) or exclude (0) the corresponding element from the original array.

// 🔹 Approach: Bitmasking
// Loop over all numbers from 0 to 2^n - 1 (inclusive).

// Each number represents one subset using its binary form.

// For each number:

// Use its binary representation to decide which elements to include in the subset.

// For each bit position j:

// Check if the j-th bit is set (i.e., equals 1).

// If yes, include nums[j] in the current subset.

// 🔹 How Bitmask Works:
// To check if the j-th bit in number i is set:

// cpp
// Copy
// Edit
// if ((1 << j) & i)
// 1 << j: creates a mask with only the j-th bit set.

// (1 << j) & i: checks if that bit is also set in i.

// 🔹 Example: nums = [1, 2, 3]
// i (decimal)	i (binary)	Subset
// 0	000	[]
// 1	001	[1]
// 2	010	[2]
// 3	011	[1, 2]
// 4	100	[3]
// 5	101	[1, 3]
// 6	110	[2, 3]
// 7	111	[1, 2, 3]

// Each binary digit tells whether to include the corresponding element:

// Rightmost bit → index 0 (nums[0])

// Middle bit → index 1 (nums[1])

// Leftmost bit → index 2 (nums[2])


// Time and Space Complexity:
// Time Complexity: 
// 𝑂
// (
// 𝑛
// ⋅
// 2
// 𝑛
// )
// O(n⋅2 
// n
//  )

// There are 
// 2
// 𝑛
// 2 
// n
//   subsets and for each subset, we may process up to n elements.

// Space Complexity: 
// 𝑂
// (
// 2
// 𝑛
// ⋅
// 𝑛
// )
// O(2 
// n
//  ⋅n)

// The result stores all subsets, each of which can have up to n elements.

