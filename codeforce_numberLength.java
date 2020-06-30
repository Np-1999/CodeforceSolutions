//https://codeforces.com/problemset/problem/489/C
import java.io.*;
import java.util.*;
public class codeforce_numberLength {
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
    public static void main(String args[]){
        InputReader in= new InputReader(System.in);
        PrintWriter w=new PrintWriter(System.out);
        int m = in.nextInt();
        int s = in.nextInt();
        if (s == 0 || s > 9 * m) {
            if (m==1 && s==0){
                w.println(0+" "+0);
            }
            else w.println(-1 + " " + -1);
        } else {
            StringBuilder sb = new StringBuilder();
            long sc = s - 1;
            for (int i = 0; i < m - 1; i++) {
                if (sc >= 9) {
                    sb.append(9);
                    sc -= 9;
                } else {
                    sb.append(sc);
                    sc = 0;
                }
            }
            if (s <= 9 * (m - 1))
                sb.append(1);
            else
                sb.append(s - 9 * (m - 1));
            sb = sb.reverse();
            //max
            sb.append(" ");
            sc = s;
            int m_ = (int) m;
            for (int i = m_ - 1; i >= 0; i--) {
                if (sc >= 9) {
                    sb.append(9);
                    sc -= 9;
                } else {
                    sb.append(sc);
                    sc = 0;
                }
            }
            w.println(sb.toString());
        }
 
        w.close();
    }       
}