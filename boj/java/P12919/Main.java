package java.P12919;

    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {
            String s = br.readLine();
            String t = br.readLine();
            Queue<String> q = new LinkedList<>();
            
            q.add(t);
            while (!q.isEmpty()) {
                String str = q.poll();
                if(str.equals(s))
                {
                    bw.write("1");
                    bw.flush();
                    return;
                }
                if(str.length() >= 2 &&str.charAt(0) == 'B')
                {
                    q.add(new StringBuilder(str.substring(1)).reverse().toString());
                }
                if(str.length() >= 2 && str.charAt(str.length() - 1) == 'A' )
                {
                    q.add(str.substring(0,str.length()-1));
                }
            }

            bw.write("0");
            bw.flush();

        }
    }
