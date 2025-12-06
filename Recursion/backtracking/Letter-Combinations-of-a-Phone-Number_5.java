//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=problem-list-v2&envId=backtracking
//https://www.youtube.com/watch?v=tWnHbSHwNmA
//method 1
class Solution {
    public void solve(String digits,String output,int index,List<String> ans,String[] mapping){
        if(index>=digits.length()){
            ans.add(output);
            return;
        }
        int number=digits.charAt(index)-'0';
        char[] value=mapping[number].toCharArray();
        for(int i=0;i<value.length;i++){
            solve(digits,output+value[i],index+1,ans,mapping);

        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        String output="";
        int index=0;
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits,output,index,ans,mapping);
        return ans;

    }
}


//method 2
class Solution {

    public void solve(String digits, StringBuilder output, int index, List<String> ans, String[] mapping) {

        if (index == digits.length()) {
            ans.add(output.toString());
            return;
        }

        int number = digits.charAt(index) - '0';
        char[] letters = mapping[number].toCharArray();

        for (char ch : letters) {

            // add character
            output.append(ch);

            // recursive call
            solve(digits, output, index + 1, ans, mapping);

            // BACKTRACK: remove last added character
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        solve(digits, new StringBuilder(), 0, ans, mapping);
        return ans;
    }
}
