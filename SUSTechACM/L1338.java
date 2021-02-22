package SUSTechACM;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class L1338 {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);
        int n= fastReader.nextInt();
        char[][]strs=new char[n][];

        int minLength=1001;
        for (int i = 0; i < n; i++) {
            strs[i]=fastReader.next().toCharArray();
            minLength=Math.min(minLength,strs[i].length);
        }

        long prefixMax=0;
        boolean preMatched =true;
        for (int i = 0; i < minLength; i++) {
            char cur=strs[0][i];
            for (int j = 0; j < n; j++) {
                if(strs[j][i]!=cur){
                    preMatched =false;
                    break;
                }
            }
            if(!preMatched){
                break;
            }else {
                prefixMax++;
            }
        }


        long suffixMax=0;
        boolean sufMatched=true;

        for (int i = 0; i < minLength; i++) {
            char cur=strs[0][strs[0].length-i-1];
            for (int j = 0; j < n; j++) {
                if(strs[j][strs[j].length-1-i]!=cur){
                    sufMatched=false;
                    break;
                }
            }
            if(!sufMatched){
                break;
            }else {
                suffixMax++;
            }
        }
        fastWriter.println(suffixMax*prefixMax);

        fastReader.close();
        fastWriter.close();
    }
    private static class FastReader implements Closeable{
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in), 16384);
            eat("");
        }

        private void eat(String s) {
            st = new StringTokenizer(s);
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while(!st.hasMoreTokens()) {
                String s = nextLine();
                if(s==null) return false;
                eat(s);
            }
            return true;
        }

        public String next() {
            hasNext();
            return st.nextToken();
        }

        public boolean nextBoolean(){
            return Boolean.parseBoolean(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat(){
            return Float.parseFloat(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger(){
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal(){
            return new BigDecimal(next());
        }

        public void close(){
            try{
                st=null;
                br.close();
            }catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }

        }
    }

    private static class FastWriter implements Closeable{
        private final PrintWriter writer;

        public FastWriter(OutputStream out){
            this.writer=new PrintWriter(out);
        }

        public void print(Object object){
            writer.write(object.toString());
        }

        public void printf(String format,Object... os){
            writer.write(String.format(format,os));
        }

        public void println(){
            writer.write(System.lineSeparator());
        }

        public void println(Object object){
            writer.write(object.toString());
            writer.write(System.lineSeparator());
        }

        @Override
        public void close() {
            writer.flush();
            writer.close();
        }
    }
}
