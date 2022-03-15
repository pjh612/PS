import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int[] arr = new int[50010];
  static int[][] d = new int[4][50010];
  static int[] sum = new int[50010];

  public static void main(String[] args) throws Exception {

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
        sum[i] = sum[i - 1] + arr[i];
    }

    int m = Integer.parseInt(br.readLine());
    for (int j = 1; j <= 3; j++) {
      for (int i = j*m; i <= n; i++) {
        d[j][i] = Math.max(d[j][i-1],d[j-1][i-m] +sum[i] - sum[i-m]);
      }

    }
  }
}