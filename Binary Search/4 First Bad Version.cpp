// The API isBadVersion is defined for you.
// bool isBadVersion(int version);
//https://leetcode.com/problems/first-bad-version/?envType=problem-list-v2&envId=binary-search
class Solution {
public:
    int firstBadVersion(int n) {
        int start=1;
        int end=n;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isBadVersion(mid)==false){
                start=mid+1;
            }
            else{
                ans=mid;
                end=mid-1;
            }
        }
        return ans;
    }
};


// 🧠 Explanation: First Bad Version (Binary Search)
// 🎯 Goal:
// Find the first version that is bad using the isBadVersion(version) API, while minimizing the number of API calls.

// 🔍 How the code works:
// Start with the full range of versions: start = 1, end = n

// Use binary search to narrow down where the bad version starts.

// In each step:

// Find the middle version: mid = start + (end - start) / 2

// If mid is not bad → the first bad version must be after mid, so move start = mid + 1

// If mid is bad → it could be the first bad version, so:

// Save it in ans

// But keep looking on the left side → end = mid - 1

// When the loop ends, return ans — the first version found that is bad.

// ✅ Example:
// If n = 5 and version 4 is the first bad one:

// isBadVersion(3) → false → move right

// isBadVersion(4) → true → save 4, search left

// Done! Return 4

// 💡 Time Complexity:
// O(log n) — very efficient!