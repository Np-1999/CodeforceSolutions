/*
    PROBLEM STATEMENT: Given weights and values of n items in ASCENDING ORDER, 
    put these items in a knapsack of capacity W to get the maximum total value in the knapsack.

    Solution: Recursive solution is if we take an item we need to add its value and reduce available
    weight and if we don't take an item we don't have to do anything.

    Dp approach:
    We take a matrix of size no of items x weight and as we keep on going down we consider items one 
    by one. As we can't include item till the weight of bag is more than that we don't change value 
    till we reach at least to the weight of item, if j is greater than weight we substract weight and
    look in upper row with index having answer of substraction.
*/
public class ZeroOneKnapSack {
    public static int  knapsack(int rem_weight,int i, int value[],int weight[]) {
        if(i==(value.length)){
            return 0;
        }
        if(rem_weight-weight[i]<0){
            return knapsack(rem_weight, i+1, value, weight);
        }
        else {
            int leave = knapsack(rem_weight, i+1, value, weight);
            int take= knapsack(rem_weight-weight[i], i+1, value, weight)+value[i];
            return Math.max(leave, take);
        }
    }
    public static int  knapsack(int rem_weight,int value[], int weight[]) {
        int dp[][] =new int [weight.length+1] [rem_weight+1];
        for(int i=0;i<=weight.length;i++){
            for(int j=0;j<=rem_weight;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else{
                    if(weight[i-1]>j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = Math.max(value[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                    }
                }
            }
        }
        return dp[weight.length][rem_weight];
    }
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        System.out.println(knapsack(50, value, weight));
    }
}