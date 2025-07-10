package ArrayDSA;

public class BestTimeToBuyAndSellAStock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++){
            int profit=prices[i]-min;
            if(profit>ans){
                ans=profit;
            }
            min=Math.min(prices[i],min);
        }
        return ans;
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellAStock obj = new BestTimeToBuyAndSellAStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = obj.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }

}
