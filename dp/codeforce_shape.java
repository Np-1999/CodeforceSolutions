import java.util.Scanner;

public class codeforce_shape {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        if(n%2==1){
            System.out.println("0");
        }
        else{
            n=n/2;
            long ans=(long)Math.pow(2, n);
            System.out.println((ans));
        }
    }
}