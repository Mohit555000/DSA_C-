//https://leetcode.com/problems/search-a-2d-matrix/description/?envType=problem-list-v2&envId=binary-search

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int left = 0;
        int right = (m*n)-1;
        while(left <= right){
            int mid = left + (right-left) / 2;
            int row = mid / n;
            int col = mid % n;
            int midVal=matrix[row][col];
            
            if(midVal==target){
                return true;
            }
            else if(midVal>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
};

//🔍 Summary: Search a 2D Matrix (Leetcode 74)
// Purpose:
// Efficiently search for a target value in a 2D matrix that is sorted in a specific way:

// Each row is sorted from left to right.

// The first integer of each row is greater than the last integer of the previous row.

// This structure allows the entire matrix to be treated as a flattened sorted 1D array, enabling the use of binary search.

// ⚙️ Logic Breakdown:
// Get the matrix dimensions:
// m = matrix.size() (rows), n = matrix[0].size() (columns).

// Perform binary search on the range 0 to m*n - 1, treating the 2D matrix as a 1D array.

// For any mid index in this range:

// Convert it to 2D coordinates:
// row = mid / n, col = mid % n

// Compare matrix[row][col] with target.

// If equal → return true

// If greater → search the left half

// If smaller → search the right half

// If loop ends, target is not found → return false.

// 🧠 Key Insight:
// By mapping 2D indices to a 1D space (mid → row, col), we can use binary search for optimal efficiency.

// ⏱ Time Complexity:
// O(log (m × n)) → Binary search on a virtual 1D array of size m * n.

// 📦 Space Complexity:
// O(1) → Constant extra space used.

// ✅ Return Value:
// true if target is found in the matrix.

// false otherwise.


// Why can we treat the 2D matrix as a 1D array?
// If a matrix has:

// m rows

// n columns

// and each row is sorted, and the first element of each row is greater than the last of the previous, the entire matrix behaves like a flattened sorted list.

// For example:
// matrix = {
//   { 1,  3,  5,  7},
//   {10, 11, 16, 20},
//   {23, 30, 34, 60}
// }
// This matrix has 3 rows (m = 3) and 4 columns (n = 4), and if you flatten it like a 1D array, it looks like:
// [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60]

// 🔄 Mapping 1D index to 2D coordinates
// If you're looping or searching in 1D (with index mid), and want to access the matrix element in 2D, you need to convert mid into (row, col).

// Formula:
// row = mid / n;
// col = mid % n;

// Why this works:
// When you divide mid / n, you get how many complete rows fit before mid — which gives you the row index.

// The remainder mid % n tells you the column offset inside that row.

// 🔢 Example
// Let’s say matrix is the same as above, and you want to know what mid = 5 maps to:

// int row = 5 / 4 = 1;
// int col = 5 % 4 = 1;

// So matrix[1][1] = 11, which is correct because index 5 in the flattened version is the 6th element, which is 11.