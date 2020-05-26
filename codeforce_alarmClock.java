import java.text.DecimalFormat;
import java.util.*;
public class codeforce_alarmClock{
    public static void main(String[] args) {
        long a,b,c,d,t;
        Scanner in=new Scanner(System.in);
        t=in.nextInt();
        for(int i=0;i<t;i++){
            a=in.nextInt();
            b=in.nextInt();
            c=in.nextInt();
            d=in.nextInt();
            if(a<=b){
                System.out.format("%d",b);
                System.out.println();
                continue;
            }
            if( c<=d){
                System.out.println(-1);
                continue;
            }
            long sleep=a-b;
            long time=c-d;

            double division=Math.ceil((double)sleep/(double)time);
            long division2= (long) division;
            long ans=(long)(b+(division2*c));
            String ans_print=String.format("%d",ans);
            System.out.println(ans_print);
        }
    }
}