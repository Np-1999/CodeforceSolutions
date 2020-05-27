//https://codeforces.com/contest/1206/problem/B
import java.util.Scanner;
public class codeforce_equalOne{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int negative_count=0;
        long ones=0;
        int flag=0;
        for(int i=0;i<t;i++){
            int no=in.nextInt();
            if(no<0){
                negative_count++;
            }
            if(no==0){
                flag=1;
            }
            ones=ones+Math.abs(Math.abs(no)-1);
        }
        if(negative_count%2==1 && flag==0){
            ones+=2;
        }
        System.out.println(ones);
    }
}