/*
    Problem Statement : Given an array of integers where each element represents 
    the max number of steps that can be made forward from that element. 
    Write a function to return the minimum number of jumps 
    to reach the end of the array (starting from the first element). If an element is 0, 
    they cannot move through that element.
        https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
*/
import java.util.Arrays;

public class jumps {
    public static int jump(int arr[], int location) {
        if(location >= arr.length){
            return 0;
        }
        int j = arr[location];
        int min = Integer.MAX_VALUE;
        int j_2;
        for(int i=1;i<=j;i++){
            j_2=jump(arr, location+i);
            if(j_2!=Integer.MAX_VALUE){
                j_2 +=1;
            }
            min = Math.min(min,j_2);
        }
        return min;
    }
    public static int dp(int arr[]){
        int dp[] = new int[arr.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i = 1 ; i<=arr.length ; i++){
            int j= arr[i-1];
            for(int k=1;k<=j;k++){
                if(i+k>arr.length){
                    continue;
                }
                dp[i+k] = Math.min(dp[i]+1,dp[i+k]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length];
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(dp(arr));
    }
}