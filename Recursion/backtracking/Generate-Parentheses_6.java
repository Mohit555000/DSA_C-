//https://leetcode.com/problems/generate-parentheses/description/?envType=problem-list-v2&envId=backtracking
//https://www.youtube.com/watch?v=WW1rYrR3tTI
class Solution {
    public void help(int n,List<String> ans,int open,int close,StringBuilder current_string){
        //base condition
        if(current_string.length()==2*n){
            ans.add(current_string.toString());
            return;
        }
        //add "("
        if(open<n){
            current_string.append("(");
            help(n,ans,open+1,close,current_string);
            current_string.deleteCharAt(current_string.length() - 1);//backtracking;
        }
        //add ")"
        if(close<open){
            current_string.append(")");
            help(n,ans,open,close+1,current_string);
            current_string.deleteCharAt(current_string.length() - 1);//backtracking
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int close=0;
        int open=0;
        StringBuilder current_string=new StringBuilder();
        help(n,ans,open,close,current_string);
        return ans;
    }
}

//aaise smj ke kar na hai ki jo n hai vo pairs nhi hai, n mtlb muje kitne opening aur kitne closing bracket allowed hai laga na/
