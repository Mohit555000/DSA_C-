//https://leetcode.com/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=sliding-window
//https://www.youtube.com/watch?v=WJaij9ffOIY

//Brute Force Approach
class Solution {
public:
    string minWindow(string s, string t) {
        int minLength = INT_MAX;
        int sIndex = -1;

        for (int i = 0; i < s.size(); i++) {
            unordered_map<char, int> freq;
            for (char c : t) freq[c]++;  // build freq map from t

            int count = 0;

            for (int j = i; j < s.size(); j++) {
                    if (freq[s[j]] > 0) {
                        count++;
                        freq[s[j]]--;
                    }

                if (count == t.size()) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        sIndex = i;
                    }
                    break;  // found valid window, break inner loop
                }
            }
        }

        return (sIndex == -1) ? "" : s.substr(sIndex, minLength);
    }
};


//Optimized approach
class Solution {
public:
    string minWindow(string s, string t) {
        map<char,int> freq;

        // Step 1: Fill frequency map with target string characters
        for(int i = 0; i < t.size(); i++) {
            freq[t[i]]++;
        }

        int left = 0, right = 0;
        int minLength = INT_MAX;
        int count = 0;
        int startIndex = -1;

        while(right < s.size()) {
            // Step 2: If current char helps fulfill t, increase count
            if(freq[s[right]] > 0) {
                count++;
            }

            // Always decrement freq (even if char not in t)
            freq[s[right]]--;
            right++;

            // Step 3: Try to shrink the window if all t characters matched
            while(count == t.size()) {
                if(right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }

                // Step 4: Remove left char from window
                freq[s[left]]++;

                // If it's a required char and its count is now > 0, we lost a match
                if(freq[s[left]] > 0) {
                    count--;
                }

                left++;
            }
        }

        return (startIndex == -1) ? "" : s.substr(startIndex, minLength);
    }
};
