public class Solution {
    public static void main(String[] args){
        int[] prices = {7, 6, 2, 3, 1};

        System.out.println(maxProfitON(prices)); // O(n)
    }

    public static int maxProfitON(int[] prices){
        int min = prices[0], prof = 0;

        for (int i = 0; i < prices.length; ++i) {
            if (min > prices[i]){
                min = prices[i];
                continue;
            }

            prof = Math.max(prof, prices[i] - min);
        }

        return prof;
    }
}
