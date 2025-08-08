// <!-- https://leetcode.com/problems/remove-element/description/?envType=problem-list-v2&envId=two-pointers -->

// class Solution {
// public:
//     int removeElement(vector<int>& nums, int val) {
//         int i=0;
//         int k=0;
//         int n=nums.size();
//         while(i<n){
//             if(nums[i]!=val){
//                 nums[k]=nums[i];
//                 k++;
//             }
//             i++;
//         }
//         return k;
//     }
// };



// same approach, since i want to do in place swap
// intution
// | Hint from Problem       | Insight                            | Leads to...                 |
// | ----------------------- | ---------------------------------- | --------------------------- |
// | "In-place"              | Can't use extra memory             | Index manipulation          |
// | "Order doesn't matter"  | Can swap with last element         | Two pointers from both ends |
// | "Return count only"     | Only need to track valid elements  | Counting via write index    |
// | "Remove while scanning" | Need to keep reading while writing | Two indices: read + write   |
// // Even if you don’t know the name “two-pointer,” think:

// // "I need to scan and write at the same time — maybe with two indices."

// // That’s all two pointers really are.