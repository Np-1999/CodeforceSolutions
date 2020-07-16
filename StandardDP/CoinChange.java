import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
    Problem Statement:Given a value V, if we want to make change for V cents, and 
    we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is 
    the minimum number of coins to make the change? 

    Logic: We will have coin array sorted. We will try include/exclude each and every 
    coin and select the one with least count.

*/
public class CoinChange {
    public static int  coins(int amount,List<Integer> c) {
        if(amount == 0){
            return 0;
        }
        else{
            int min = Integer.MAX_VALUE;
            int value=0;
            Iterator<Integer> iterator = c.iterator(); 
            while(iterator.hasNext()){
                int coin_value=iterator.next();
                if(coin_value>amount){
                    continue;
                }
                value = coins(amount-coin_value, c);
                if (value != Integer.MAX_VALUE ) {
                    value += 1;
                }
                min = Math.min(min,value);
            }
            return min;
        }
    }
    public static int dp(int amount , List<Integer> c ) {
        int dp[] = new int [amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int j=1;j<=amount;j++){
            int min = Integer.MAX_VALUE;
            int value = 0;
            Iterator <Integer> i = c.iterator();
            while(i.hasNext()){
                int coinvalue = i.next();
                if(coinvalue>j){
                    continue;
                }
                value = dp[j-coinvalue];
                if (value != Integer.MAX_VALUE){
                    value += 1;
                }
                min  = Math.min(min,value);
            }
            dp[j] = min;
        }
        return dp[amount];
    }
    public static void print_result(int ans) {
        if( ans == Integer.MAX_VALUE ) {
            System.out.println("Not possible to generate change");
        }
        else{
            System.out.println("No of coins required is "+ans);
        }
    }
    public static void main(String[] args) {
        List <Integer> c = new ArrayList<Integer>(List.of(25,10,5));
        System.out.println("Call to Recursive function ");
        print_result(coins(30, c));
        System.out.println("Call to DP");
        print_result(dp(30,c));
    }
}