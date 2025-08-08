//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/1641032276/?envType=problem-list-v2&envId=string
//Method 1
class Solution {
public:
    int strStr(string haystack, string needle) {
        return haystack.find(needle);
    }
};

//  Summary:
// Isme C++ ka built-in function .find() use kiya gaya hai.

// .find(needle) haystack me needle ka first index return karta hai agar match milta hai.

// Agar match nahi milta, toh find() -1 return karta hai.

// Ye method fast and clean hai, lekin internal implementation C++ ke engine pe depend karta hai.

//method 2
class Solution {
public:
    int strStr(string haystack, string needle) {
        int h_length=haystack.size();
        int n_length=needle.size();
        for(int i=0;i<h_length-n_length+1;i++){
            if(haystack.substr(i,n_length)==needle){
                return i;
            }
        }
        return -1;
    }
};

// Isme hum manually har possible index pe haystack ka substring leke check karte hain ki kya woh needle ke barabar hai.

// haystack.substr(i, n_length) ka matlab hai i se start karke n_length characters lena.

// Agar match milta hai → index return kar do.

// Agar loop ke baad bhi kuch match nahi mila → -1 return.