package java.P10836;

import java.io.*;

import java.util.*;


public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[] grow_weight;
    static int[][] grow;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        grow = new int[n][3];
        grow_weight = new int[2*m-1];
        for (int i = 0; i < 2*m-1; i++) {
            grow_weight[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int l = a; l < a + b; l++) {
                    grow_weight[l]++;
            }
            for (int l = a+b; l < 2*m-1;l++)
                grow_weight[l]+=2;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(grow_weight[m-i-1] + " ");
            for (int j = 1; j < m; j++) {
                System.out.print(grow_weight[m + j - 1] + " ");
            }
            System.out.println("");
        }
    }

}
