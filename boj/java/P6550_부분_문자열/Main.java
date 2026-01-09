package java.P6550_부분_문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        while(true) {
            String line = br.readLine();
            if(line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            String t = st.nextToken();

            int i =0;
            int j =0;

            while(i < s.length() && j < t.length()) {

                if(s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }

            if(i == s.length()) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
        }
        bw.flush();

    }
}

