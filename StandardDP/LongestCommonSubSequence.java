/*
    Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. 
    A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
    For example, "abc", "abg", "bdf", "aeg", "acefg", .. etc are subsequences of "abcdefg".
    
    Logic: If we found a match increment count and here we need not to set to count to 0 as we did
    for substring as we are allowed to find more matching characters throughout the string.

    And for dp if characters doesn't match we can copy max value from i-1 j or i j-1
*/
public class LongestCommonSubSequence {
    public static int lcs(String a, String b, int m, int n, int count) {
        if ( n==0 || m==0 ) {
            return count;
        }
        else if( a.charAt(m-1)==b.charAt(n-1) ){
            return lcs(a, b, m-1, n-1, count+1);
        }
        return Math.max(lcs(a, b, m-1, n, count),lcs(a, b, m, n-1, count));
    }
    public static int dp(String a, String b) {
        int m = a.length();
        int n = b.length();
        int lcs_dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    lcs_dp[i][j] = 0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1)){
                    lcs_dp[i][j] = lcs_dp[i-1][j-1]+1;
                }
                else{
                    lcs_dp[i][j] = Math.max(lcs_dp[i-1][j],lcs_dp[i][j-1]);
                }
            }
        }
        return lcs_dp[m][n];
    }
    public static void main(String[] args) {
        String a = "AGGTAB"; 
        String b = "GXTXAYB";
        int m = a.length();
        int n = b.length();
        System.out.println(dp(a, b));
    }
}