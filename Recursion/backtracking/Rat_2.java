class Solution {
    public void printPermutation(char[] arr,int index,ArrayList<String> result){
        
        //base case
        if(index==arr.length){
            result.add(new String(arr));
            return;
        }
        
        for(int j=index;j<arr.length;j++){
            //swap
            char temp=arr[index];
            arr[index]=arr[j];
            arr[j]=temp;
            //recursion
            printPermutation(arr,index+1,result);
            //backtrack
            temp=arr[index];
            arr[index]=arr[j];
            arr[j]=temp;
        }
    }
    public ArrayList<String> findPermutation(String s) {
        // Code here
        
        ArrayList<String> result=new ArrayList<String>();
        printPermutation(s.toCharArray(),0,result);
        return result;
    }
}