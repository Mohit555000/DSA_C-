//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
// Youtube Link - https://www.youtube.com/watch?v=pBWCOCS636U&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=2&ab_channel=takeUforward
class Solution {
public:
    int maxScore(vector<int>& arr, int k) {
     int lsum=0;
     int rsum=0;
     int maxSum=0;
     int rindex=arr.size()-1;
     for(int i=0;i<=k-1;i++){
        lsum=lsum+arr[i];
     }   
     maxSum=lsum;
     for(int i=k-1;i>=0;i--){
        lsum=lsum-arr[i];
        rsum=rsum+arr[rindex];
        rindex=rindex-1;

        maxSum=max(maxSum,lsum+rsum);
     }
     return maxSum;

    }
};


// Summary 


// Mujhe ek array diya gaya hai, jisme se mujhe exactly k cards lene hain — ya to start se ya end se, lekin middle se nahi.

// Example ke liye:
// Agar cardPoints = [1, 2, 3, 4, 5, 6, 1] aur k = 3, to main aise combinations le sakta hoon:

// [1, 2, 3] (pure start se)

// [1, 2, 1] (2 start se, 1 end se)

// [1, 1, 6], [1, 6, 5] (start aur end mix)

// ✅ Step-by-Step Soch (Logic):
// lsum banaya maine start ke cards ka sum rakhne ke liye.

// rsum banaya end ke cards ka sum rakhne ke liye.

// Sabse pehle maine lsum calculate kiya — first k elements ka sum leke.

// Abhi tak best sum mujhe wahi lag raha hai, to maxSum = lsum set kar diya.

// Ab main ek-ek card left se hataunga aur right se ek-ek card add karunga:

// lsum me se ek card hata ke (lsum -= arr[k - 1 - i])

// rsum me ek right card add karke (rsum += arr[n - 1 - i])

// Har step pe check karunga ki maxSum update karna hai ya nahi (max(maxSum, lsum + rsum))

// Right se element lene ke liye mujhe uska index chahiye hota hai, isiliye rindex (ya arr[n - 1 - i]) ka use kiya.

// 🎯 Final Result:
// End tak, maxSum ke paas wahi answer hoga jo maximum score de sakta hai k cards leke — chahe front se ho ya end se.

