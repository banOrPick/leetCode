import org.junit.Test;

public class 买卖股票的最佳时机II122 {
    @Test
    public void test() {
        maxProfit(new int[]{7,1,5,3,6,4});
    }
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
