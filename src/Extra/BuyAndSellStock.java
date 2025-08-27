package Extra;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] arr2= {7,6,4,3,1};
        int ans = maxProfit(arr);
        System.out.println(ans);
    }
    public static int maxProfit(int[] prices) {
        int buy= Integer.MAX_VALUE;
        int sell=0;
        for(int price:prices){
            if(price<buy){
                buy=price;
            }else if(price-buy > sell){
                sell=price-buy;
            }
        }
        return sell;
    }
}
