class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitMade = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; ++i){
            for(int j = i+1; j < prices.length; ++j){
              //for each ith day, checking the profit, when succedding day have higher price
               if(prices[j] > prices[i]){
                   maxProfitMade = Math.max(maxProfitMade, prices[j]-prices[i]);
               }
           }
        }
      //returning 0, in case maxProfit value is negative, for ex: prices = [7,6,5,4,3,2,1], here there is no day on which profit can be made.
       return Math.max(maxProfitMade,0); 
    }
}
// TC O(n^2) SC: O(1)

/*⭐⭐⭐⭐⭐OPTIMAL SOLUTION⭐⭐⭐⭐⭐*/
class Solution {
    public int maxProfit(int[] prices) {
        //Initially, maximum profit would be 0 and let's consider minimum price of stock is at day - 1
        int maxProfit = 0, minPrice = prices[0];
        //iterate from next day
        for(int i = 1; i < prices.length; ++i){
            //current profit would be difference of todays (selling day) price 
            //and previous (buying day) minimum price
            int currProfit = prices[i] - minPrice;
            //maintaining maximum profit
            maxProfit = Math.max(currProfit, maxProfit);
            //updating minimum price for next day, considering previous minimum and current day price
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
// TC: O(N) SC: O(1)
