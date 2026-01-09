package java.P7579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  static int[][] arr = new int[101][2];
  static int[][] d = new int[101][10001];
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int sum = 0;
    int ans = 10000001;
    for (int i = 1; i <= n; i++) {
      arr[i][0] = Integer.parseInt(st.nextToken());

    }
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i][1] = Integer.parseInt(st.nextToken());
      sum += arr[i][1];
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        if (j - arr[i][1] >= 0) {
          d[i][j] = Math.max(d[i - 1][j - arr[i][1]] + arr[i][0], d[i - 1][j]);
        } else {
          d[i][j] = d[i - 1][j];
        }
        if (d[i][j] >= m) {
          ans = Math.min(ans, j);
        }
      }
    }
    System.out.println(ans);
  }
}
