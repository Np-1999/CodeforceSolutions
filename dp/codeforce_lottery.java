
//https://codeforces.com/problemset/problem/996/A
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class codeforce_lottery{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int coins[]={100,20,10,5,1};
        int n=in.nextInt();
        int sum=0;
        for(int i=0;i<5;i++){
            sum=sum+(int)(n/coins[i]);
            n=n%coins[i];
        }
        //Old Approach
        //int dp[]=new int[n+1];
        /*int coins[]={100,20,10,5,1};
        for(int i=0;i<5;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE-1);
        }
        for(int i=0;i<5;i++){
            dp[i][0]=0;
        }
        for(int j=1;j<=n;j++){
            if(j%coins[0]==0)
                dp[0][j]=j/coins[0];
        }  
        for(int i=1;i<5;i++){
            for(int j=1;j<=n;j++){
                if(j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                    continue;
                }
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
            }
        }*/
        /*for(int i=0;i<5;i++){
            for(int j=0;j<=n;j++){
                if(j<i){
                    dp[i][j]=dp[i-1][j];
                    continue;
                }
                if(j%coins[i]==0){
                    dp[i][j]=Math.min(dp[i-1][j-coins[i]],j/coins[i]);
                    continue;
                }
                dp[i][j]=dp[i-1][j-coins[i]]+1;
            }
        }*/
       System.out.println(sum);
    }
}