/*
    Problem Statement : Given a rod of length n inches and an array of prices that 
    contains prices of all pieces of size smaller than n. Determine the maximum value 
    obtainable by cutting up the rod and selling the pieces.

*/
/*
    Logic : We can choose whether to cut the rod for certain length 
    let that length be i if we cut the rod at lenght i we have two pieces
    one with length i and other with length l-i then we try to optimize
    our solution for both the pieces and we can't divide rod once its at
    length 1 therefore length 1 is our base case.
    
    Observation: As we are calling recursive function in a loop we will
    need nested loops for dp implementation.
*/
import java.util.Arrays;
public class CutTheRod {
    public static int cutTheRod(int v[],int length) {
        if(length==1){
            return v[0];
        }
        else {
            int max=0;
            int cut=0;
            for(int i=1;i<length;i++){
                cut=cutTheRod(v, length-i)+cutTheRod(v, i);
                max=Math.max(max, cut);
            }
            max = Math.max(v[length-1],max); 
            return max;
        }
        
    }
    public static int dp(int v[],int length) {
        int dp[] = new int[length+1];
        dp[0]=0;
        for(int i=1;i<=length;i++){
            int max=dp[i];
            int cut=0;
            for(int j=1;j<i;j++){
                cut=dp[j]+dp[i-j];
                max = Math.max(max,cut);
            }
            max = Math.max(max, v[i-1]);
            dp[i] = max;
        }
        return dp[length];
    }
    public static void main(String[] args) {
        int v[]={1,   5,   8,   9,  10,  17 ,17 ,20};
        System.out.println(cutTheRod(v, 8));
        System.out.println(dp(v, 8));
    }
}