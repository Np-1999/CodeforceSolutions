//https://codeforces.com/problemset/problem/455/A
package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class codeforce_boredom {
 
    static long count [];
    static long dp[];
    static int max=100007;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        count= new long [max];
        dp= new long [max];
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            count[input.nextInt()]++;
        }
        dp[0]=0;
        dp[1]=count[1];
        for (int i = 2; i <max; i++) {
            dp[i]=Math.max(dp[i-1], dp[i-2]+count[i]*i);
        }
        System.out.println(dp[max-1]);
    }
 
}