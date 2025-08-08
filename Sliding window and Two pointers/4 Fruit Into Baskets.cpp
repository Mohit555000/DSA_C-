//https://leetcode.com/problems/fruit-into-baskets/description/
//https://www.youtube.com/watch?v=e3bs0uA1NhQ&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=5
class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        map<int,int> map;
        int left=0, right=0;
        int maxLength=0;
        int n=fruits.size();
        int k=2;
        int length=0;
        while(right<n){
            map[fruits[right]]++;
            if(map.size()>2){
                map[fruits[left]]--;
                if(map[fruits[left]]==0){
                    map.erase(fruits[left]);
                }
                left++;
            }
            if(map.size()<=2){
                length=right-left+1;
                maxLength=max(maxLength,length);
            }
            right++;
        }
        return maxLength;
    }
};