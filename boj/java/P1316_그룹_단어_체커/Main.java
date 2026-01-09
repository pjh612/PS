package java.P1316_그룹_단어_체커;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean[] flags = new boolean[26];
            String line = br.readLine();
            boolean isGroupWord = true;
            char prev = '?';
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c != prev) {
                    if (!flags[c - 'a']) {
                        flags[c - 'a'] = true;
                    } else {
                        isGroupWord = false;
                        break;
                    }
                }
                prev = c;
            }

            if (isGroupWord) {
                answer++;
            }

        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }


}
