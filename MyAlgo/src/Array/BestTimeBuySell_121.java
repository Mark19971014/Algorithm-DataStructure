package Array;

public class BestTimeBuySell_121 {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int length = prices.length;
        int profit = 0;
        while(sell < length){

          if(prices[buy] < prices[sell]){
              profit = Math.max(prices[sell] - prices[buy],profit);
          }else {
              buy = sell;
          }

          sell++;
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeBuySell_121 solution = new BestTimeBuySell_121();
        int[] prices = {10,1,5,3,9,4,4,1,4,5,6,8,111};
        System.out.println(solution.maxProfit(prices));
    }
}
