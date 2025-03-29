public class 买卖股票的最佳时机121 {
    public static void main(String[] args) {

    }
//暴力破解
//    public static int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int n = prices.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
//            }
//        }
//        return maxProfit;
//    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if(prices[i]<min){
                min = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }

        }
        return maxProfit;
    }
}
