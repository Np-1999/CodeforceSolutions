import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
public class codeforce_IlyaIOOptimizes {
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        FastReader in= new FastReader();
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
            System.out.println(dp[b]-dp[a]);
        }
    }
}