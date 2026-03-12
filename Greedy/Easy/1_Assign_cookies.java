//https://leetcode.com/problems/assign-cookies/description/
//https://www.youtube.com/watch?v=DIX2p7vb9co&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea
class Solution {
    public int findContentChildren(int[] g, int[] c) {
        int n=g.length;
        int m= c.length;
        int l=0;
        int r=0;
        Arrays.sort(g);
        Arrays.sort(c);
        while(l<n && r<m){
            if(c[r]>=g[l]){
                l++;
            }
            r++;
        }
        return l;
    }
}