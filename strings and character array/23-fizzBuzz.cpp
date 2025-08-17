// https://leetcode.com/problems/fizz-buzz/description/?envType=problem-list-v2&envId=string

class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> ans;
        for(int i=1;i<=n;i++){
            if((i%3==0)&&(i%5==0)){
                ans.push_back("FizzBuzz");
            }
            else if(i%3==0){
                ans.push_back("Fizz");
            }
            else if(i%5==0){
                ans.push_back("Buzz");
            }
            else{
                string stri=to_string(i);
                ans.push_back(stri);
            }
        }
        return ans;
    }
};