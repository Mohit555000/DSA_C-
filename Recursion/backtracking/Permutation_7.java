//https://leetcode.com/problems/permutations/?envType=problem-list-v2&envId=backtracking
//https://www.youtube.com/watch?v=N4gJDGdhpLw
class Solution {
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void help(int[] nums,List<List<Integer>> ans,List<Integer> combination,int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(combination));
            return;
        }
        //swap
        
        for(int i=index;i<nums.length;i++){
            //swap
            swap(nums,index,i);
            combination.add(nums[index]);
            //recursion
            help(nums,ans,combination,index+1);
            //backtrack
            combination.remove(combination.size()-1);
            swap(nums,index,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        int index=0;
        help(nums,ans,combination,index);
        return ans;
    }
}
