package java.P15990;

    import java.io.*;


public class Main {
        static int dp[][] =new int[100001][4];
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static void main(String[] args) throws IOException {

            int T = Integer.parseInt(br.readLine());
            dp[1][1]= 1;
            dp[2][2]= 1;
            dp[3][1] = 1;
            dp[3][2] =1;
            dp[3][3] = 1;
            for(int i=4;i<=100000;i++)
            {
                dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
                dp[i][2] = (dp[i-2][1] +dp[i-2][3])% 1000000009;
                dp[i][3] = (dp[i-3][1] + dp[i-3][2])% 1000000009;
            }
            for(int i=0;i<T;i++)
            {
                int n = Integer.parseInt(br.readLine());
                int val = ((dp[n][1] + dp[n][2]) % 1000000009+dp[n][3])% 1000000009;
                bw.write(Integer.toString(val)+"\n");
            }
            bw.flush();
        }
    }
