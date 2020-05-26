//Problem Statement :https://codeforces.com/problemset/problem/580/A
package dp;
import java.util.*;
public class codeforce_kefa{
    public static void main(String[] args) {
        int t;
        Scanner in= new Scanner(System.in);
        int best=1;
        t=in.nextInt();
        long arr[]=new long[t];
        for(int i=0;i<t;i++){
            arr[i]=in.nextInt();
        }
        int value[]=new int[t];
        for(int i=0;i<t-1;i++){
            value[i]=Math.max(value[i],1);
            if(arr[i]<=arr[i+1]){
                value[i+1]=value[i]+1;
            }
            if(value[i]>best ||value[i+1]>best)
                best=Math.max(value[i],value[i+1]);
        }
        System.out.println(best);
    }
    
}