/*
    Problem Statement : https://codeforces.com/problemset/problem/1195/C

    logic: 
    Recursive logic: At any point in time we have two options that is to include a certain player
    or don't include a player. If we include player from a row next we need to change 
    the row that is done by xor ('^') operator. As we need to check whether best selection end with 
    row 1 or row 2 for recursive function we call the function with index 0 and 1 then choose max out of
    it.

    Dp logic: Here dp logic is kind of challenging. So as recursive logic to work we needed 2 calls.
    for dp we need 2 arrays or a multidimensional array. we intialize both arrays with 0 at index 0.
    And at index one height of first player in both rows in there array. From now on as we have choice
    to whether to include player from other row or not which can be done using math.max function like if 
    we want to add player from row two we will check if it is giving us max value for current scenario
    in for row 1's dp if it is then we will add to row 1's dp same for row 2 and finally we will check
    whose value is highest for index k.
*/
import java.util.Arrays;
import java.util.Scanner;

public class basketBallTeam{
    public static int choose_player(int matrix[][],int k,int index) {
        if(k<0) {
            return 0;
        }
        else {
            int choice_1 = choose_player(matrix,k-1,index);
            int choice_2 = choose_player(matrix,k-1,index^1)+matrix[index][k];
            return Math.max(choice_1, choice_2);
        }
    }
    public static long dp(int matrix[][],int k) {
        long dp[][] = new long[2][k+1];
        dp[0][0]=0;
        dp[1][0]=0;
        dp[0][1] = matrix[0][0];
        dp[1][1] = matrix[1][0];
        for(int i=2;i<=k;i++) {
            dp[0][i] = Math.max(dp[1][i-1]+matrix[0][i-1],dp[0][i-1]);
            dp[1][i] = Math.max(dp[0][i-1]+matrix[1][i-1],dp[1][i-1]);
        } 
        return Math.max(dp[0][k],dp[1][k]);
    }
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int matrix[][] = new int[2][k];
        k = k-1;
        for(int i=0;i<2;i++){
            for(int j=0;j<=k;j++){
                matrix[i][j] = in.nextInt(); 
            }
        }
        System.out.println(dp(matrix,k+1));
    }
}