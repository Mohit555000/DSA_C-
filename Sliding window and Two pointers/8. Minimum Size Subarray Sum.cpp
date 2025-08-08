// https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=sliding-window
//Brute force approach
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int minLen=INT_MAX;
        for(int i=0;i<nums.size();i++){
            for(int j=i;j<nums.size();j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum=sum+nums[k];
                    if(sum>=target){
                        minLen=min(j-i+1,minLen);
                        break;
                    }
                }
            }
        }
        return (minLen == INT_MAX) ? 0 : minLen;
    }
};


//Optimized approach
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left=0;
        int sum=0;
        int minLength=INT_MAX;
        for(int right=0;right<nums.size();right++){
            sum=sum+nums[right];
            while(sum>=target){
                minLength=min(right-left+1,minLength);
                sum=sum-nums[left];
                left++;
            }
        }
       return (minLength == INT_MAX) ? 0 : minLength;
    }
};



//  Tumhara sawal:
// // Agar hum if (sum >= target) ki jagah while (sum >= target) lagate hain, toh kya time complexity badh jaayegi?

// ✅ Short Answer:
// Nahi, time complexity O(n) hi rahegi. Koi dikkat nahi hai.



// 🔁 Kitne baar chalega right pointer?
// right har step mein aage badh raha hai, total maximum n baar chalega (jahan n = array ka size)

// ↩️ Kitne baar chalega left pointer?
// left bhi sirf aage badhta hai (kabhi peeche nahi jaata).

// Wo bhi maximum n baar hi chalega.

// 🎯 Iska matlab:
// Dono pointers (left aur right) milke maximum 2n steps hi lenge.

// So, total operations = O(n)
