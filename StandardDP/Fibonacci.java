public class Fibonacci{
    //Recursive Approach
    public static int fibo (int n) {
        if(n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        else{
            return fibo(n-2)+fibo(n-1);
        }
            
    }
    //DP approach
    public static int dp(int n) {
        int a[] = new int[n+1];
        a[0]=0;
        a[1]=1;
        for(int i=2;i<=n;i++){
            a[i] = a[i-2]+a[i-1];
        }
        return a[n];
    }
    public static void main(String[] args) {
        System.out.println(dp(3));
    }
}