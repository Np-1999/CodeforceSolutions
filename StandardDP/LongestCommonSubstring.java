/*
    Problem Statement :Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

        Examples :

            Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
            Output : 5
            The longest common substring is “Geeks” and is of length 5.

            Input : X = “abcdxyz”, y = “xyzabcd”
            Output : 4
            The longest common substring is “abcd” and is of length 4.

            Input : X = “zxabcdezy”, y = “yzabcdezx”
            Output : 6
            The longest common substring is “abcdez” and is of length 6.

    Logic: We will increment the counter when we get a match else we will reset counter to zero
    and look for some other match.
    And it's simple to implement in dp

*/
public class LongestCommonSubstring {
    public static int lcs(int i,int j,String string1, String string2, int count) {
        if(i==0 || j==0){
            return count;
        }
        if(string1.charAt(i-1) == string2.charAt(j-1) ){
            count = lcs(i-1, j-1, string1, string2,count+1);
        }
        count = Math.max(count, Math.max(lcs(i-1,j,string1,string2,0),lcs(i, j-1, string1, string2, 0)));
        return count;
    }
    public static int dp(String a, String b) {
        int n = a.length();
        int m = b.length();
        int LCS[][] = new int [n+1] [m+1];
        LCS[0][0] = 0;
        int result = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1) ==  b.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] +1;
                    result = Math.max(result, LCS[i][j]);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String a="xyzabcd";
        String b="abcdxyz";
        int n = a.length();
        int m = b.length(); 
        System.out.println(lcs(n, m, a, b, 0));
        System.out.println(dp(a, b));
    }
}