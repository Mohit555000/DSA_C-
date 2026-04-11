//https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1
//https://www.youtube.com/watch?v=HZOUwKCKF5o
class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(prices);
        
        int n = prices.length;

        // Minimum cost
        int minCost = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            minCost += prices[i];
            i++;
            j -= k;
        }

        // Maximum cost
        int maxCost = 0;
        i = n - 1;
        j = 0;
        while (i >= j) {
            maxCost += prices[i];
            i--;
            j += k;
        }

        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }
}