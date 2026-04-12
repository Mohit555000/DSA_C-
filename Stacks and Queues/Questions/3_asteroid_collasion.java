//https://leetcode.com/problems/asteroid-collision/
//https://www.youtube.com/watch?v=_eYGqw_VDR4
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int astr:asteroids){
            boolean isDestroyed=false;
            while(!st.isEmpty() && astr<0 && st.peek()>0){
                if(Math.abs(astr)>st.peek()){
                    st.pop();
                    continue;
                }
                else if(Math.abs(astr)==st.peek()){
                    st.pop();
                }
                isDestroyed=true;
                break;
            }
            if(!isDestroyed){
                st.push(astr);
            }
        }
        int[] result=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            result[i]=st.pop();
        }
        return result;
    }
}