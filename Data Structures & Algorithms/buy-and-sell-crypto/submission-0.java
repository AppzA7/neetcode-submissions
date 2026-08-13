class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length-1;
        int biggestPrice = prices[n];
        int profit = 0;
        for(int i=n-1; i >=0; i--) {
            biggestPrice = Math.max(biggestPrice, prices[i]);
            profit = Math.max(profit, biggestPrice - prices[i]);
        }

        return profit;
    }
}
