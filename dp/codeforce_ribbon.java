//https://codeforces.com/problemset/problem/189/A
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class codeforce_ribbon{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int dp[]=new int[n+1];
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=a;i<=n;i++){
            dp[i]=Math.max(dp[i],dp[i-a]+1);
        }
        for(int i=b;i<=n;i++){
            dp[i]=Math.max(dp[i],dp[i-b]+1);
        }
        for(int i=c;i<=n;i++){
            dp[i]=Math.max(dp[i],dp[i-c]+1);
        }
        System.out.println(dp[n]);
    }
}