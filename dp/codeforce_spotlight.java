//https://codeforces.com/contest/729/problem/B
import java.util.*;
import java.io.*;
public class codeforce_spotlight {
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    public static void main(String[] args) {
        //input
        InputReader in=new InputReader(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n=in.nextInt();
        int m=in.nextInt();
        int input_array[][]=new int[n][m];
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                input_array[i][j]=in.nextInt();
            }
        }
        int flag=0;
        int ans=0;
        int imp_index=0;
        //Left Directed Spotlights traversal
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int s=0;
                if (input_array[i][j]==1){
                    for(int k=j+1;k<m;k++){
                        if(input_array[i][k]==0){
                            s++;
                        }
                    }
                    ans+=s;
                    break;
                }
            }   
        }
        //Right Directed spotlights
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                int s=0;
                if(input_array[i][j]==1){
                    for(int k=j-1;k>=0;k--){
                        if(input_array[i][k]==0){
                            s++;
                        }
                    }
                    ans+=s;
                    break;
                }
            }   
        }
        //down directed spotlights traversal
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(input_array[j][i]==1){
                    int s=0;
                    for(int k=j-1;k>=0;k--){
                        if(input_array[k][i]==0){
                            s++;
                        }
                    }
                   ans+=s;
                   break;
                }
                
             }    
        }
        //up Directed spotlights
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int s=0;
                if(input_array[j][i]==1){
                    for(int k=j+1;k<n;k++){
                        if(input_array[k][i]==0){
                            s++;
                        }
                    }
                    ans+=s;
                    break;
                }
            }
        }
        out.println(ans);
        out.close();
    }
}