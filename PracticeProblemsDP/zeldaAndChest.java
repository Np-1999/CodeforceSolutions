import java.util.Arrays;
/*
    Problem Statement : Zelda is asked to choose chest such that she cannot choose chest at cosecutive
    location. And your assigned the task of choosing chest such that it optimizes total value chosen 
    by zelda. 
*/
public class zeldaAndChest {
    //BackTrack Approach
    public static int backTracking(int v[],int k) {
        if(k<=0) {
          return 0;  
        }
        else {
            int take =  backTracking(v, k-2) + v[k-1];
            int leave = backTracking(v, k-1);
            return Math.max(take,leave);
        }
    }
    //Dp
    public static int dp(int v[]) {
        int dp[] = new int [v.length+1];
        dp[0] = 0;
        int take=0;
        for(int i=1;i<=v.length;i++) {
            int leave = dp[i-1];
            if(i==1) {
                take = v[i-1];
            }
            else {
                take = dp[i-2]+v[i-1];
            }
            dp[i] = Math.max(take,leave);
        }
        return dp[v.length];
    }
    public static void main(String[] args) {
        int v[]= new int[5];
        for(int i=0;i<5;i++){
            v[i] = (int) (Math.random()*15);
        }
        System.out.println(Arrays.toString(v));
        System.out.println(backTracking(v, 5));
        System.out.println(dp(v));
    }
    
}