class Solution {
    public:
        vector<vector<int>> subsetsWithDup(vector<int>& nums) {
             sort(nums.begin(), nums.end());
            set<vector<int>> master_set;
            vector<vector<int>> finalResult;
            int n =nums.size();
            for(int i=0;i<pow(2,n);i++){
                vector<int> value;
                for(int j=0;j<n;j++){
                    if((1<<j)&i){
                        value.push_back(nums[j]);
                    }
                }
                master_set.insert(value);
            }
            for(vector<int> ans:master_set){
                finalResult.push_back(ans);
            }
            return finalResult;
        }
    };
    //Sorting nums before generating subsets ensures that duplicate subsets are caught correctly by the set, since [1,2] and [2,1] would otherwise be treated as different.

    //The use of set helps remove duplicates, but it could be inefficient for large inputs. A more optimized approach uses backtracking with pruning.


    //this is the brute force approach

    