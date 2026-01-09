package java.P10159;


import java.io.*;

import java.util.*;


public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[] grow_weight;
    static int[][] grow;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j)
                    d[i][j] = 987654321;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            d[a][b] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (d[j][k] > d[j][i] + d[i][k])
                        d[j][k] = d[j][i] + d[i][k];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                cnt += d[i][j] == 987654321 && d[j][i] == 987654321 ? 1 : 0;
            }
            System.out.println(cnt);
        }
    }

}
