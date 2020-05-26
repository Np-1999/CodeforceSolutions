//https://codeforces.com/problemset/problem/1323/A
import java.util.Scanner;

public class codeforce_evenSubset {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int nos=in.nextInt();
            int arr[]=new int[nos];
            for(int j=0;j<nos;j++){
                arr[j]=in.nextInt();
            }
            int count=0;
            for(int j=0;j<nos && count==0;j++){
                if(arr[j]%2==0){
                    System.out.println("1");
                    System.out.println((j+1));
                    count++;
                }
            }
            if(count!=0){
                continue;
            }
            for(int k=1;k<nos && count==0;k++){
                for(int j=0;j+k<nos && count==0 ;j++){
                    if((arr[j]+arr[j+k])%2==0){
                        System.out.println(k+1);
                        System.out.println((j+1)+" "+(j+k+1));
                        count++;
                    }
                }
            }
            if(count==0){
                System.out.println("-1");
            }
        }
    }    
}