//https://codeforces.com/problemset/problem/313/B
import java.util.Arrays;
import java.util.Scanner;

public class codeforce_Ilya {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String n=in.nextLine();
        int dp[]=new int[n.length()+1];
        int counter=0;
        for(int i=1;i<n.length();i++){
            if(n.charAt(i-1)==n.charAt(i)){
                counter++;
                
            }
            dp[i+1]=counter;
        }
       
      
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int ans=dp[b]-dp[a];
            System.out.println(ans);
        }
    }
}
//This code logic is good bt it exceeds time limit. however when I looked into other submission 
//They have same logic but different I/O therefore there code is working faster than mine.