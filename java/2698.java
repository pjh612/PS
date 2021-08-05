import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [][][]dp= new int[101][101][2];
    public static void main(String[] args) throws IOException {
        int T;
        T= Integer.parseInt(br.readLine());
        dp[1][0][0] = 1;
        dp[2][0][0]= 2;
        dp[2][0][1]= 1;
        dp[2][1][1] = 1;
        for (int i = 3; i <= 100;i++)
        {
            for(int j=0;j<=i-1;j++)
            {

               dp[i][j][0] +=dp[i-1][j][0];
               dp[i][j][0] +=   dp[i-1][j][1];

                dp[i][j][1] += dp[i-1][j][0];
                if(j-1>=0)
                dp[i][j][1] +=dp[i-1][j-1][1];
            }
        }
        for(int i=0;i<T;i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println((dp[a][b][0]+dp[a][b][1]) );
        }
    }

}
