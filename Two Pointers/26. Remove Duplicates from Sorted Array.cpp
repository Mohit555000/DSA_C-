// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=problem-list-v2&envId=two-pointers



// why two pointers
// array is sorted
// we have to remove the duplicates in place,
// unique elements


// so approach is i need three pointers, i for count of unique elements, j for i teration and k for at which place the number will be swapped


// solution

// class Solution {
// public:
//     int removeDuplicates(vector<int>& nums) {
//         int i=0;
//         int j=i+1;
//         int k=i+1;
//         int n=nums.size();
//         while(j<n){
//             if(nums[i]!=nums[j]){
//                 nums[k]=nums[j];
//                 i++;
//                 k++;
//             }
//             j++;
//         }
//         return i+1;
        
//     }
// };


// i have to swap only if the elemets are not same at ith and jth index. if the elemets are same just continue the iteration check the dry return
// input
// [0 0 1 1 1 2 2 3 3 4 4 4 5 5 6]
// expected output->7
// [0 1 2 3 4 5 6 3 3 4 4 4 5 5 6]

// 0 i                0 i                                                                                                                      
// 0 j k (1!=j) j++   0 k                                                                                                                      
// 1                  1 j  (i==j replace the element at jth position with kth position and increase both i and k, j will increasw by default and continue the process till j < n where n is the siez of the vector)      
// 1                  1                                                                                                                        
// 1                  1
// 2                  2
// 2                  2
// 3                  3
// 3                  3
// 4                  4
// 4                  4
// 4                  4
// 5                  5
// 5                  5
// 6                  6

