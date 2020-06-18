package app;

public class MaxProfit {
    /**
     * 112.何时卖掉股票能获取最大利益
     * 
     * 当天买当天卖的收益是 0,同一天中,把之前的卖掉能继续买 [7,1,5,3,6,4] -> 1 <= 5 , 3 <= 6
     * 7和4属于当天买卖收益为0的情况 所以在保证局部收益不为负的情况下 5-1 + 6-3 是最大的收益 故这题的核心在于: -> a<= b<= c<= d
     * d-a = d-c + c-b + b-a 即只要收益不为负,把正的收益累加
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 <= prices.length && prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    /**
     * 暴力搜索
     * 
     */
    private int res = 0;

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    public void dfs(int[] prices, int index, int length, int status, int profit) {

    }

    /**
     * 动态规划
     */

    public static void main(String[] args) {

    }
}