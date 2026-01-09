package java.P21608;

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int []dx = {1,0,0,-1};
    static int []dy= {0,1,-1,0};
    public static void main(String[] args) throws IOException {
      int n = Integer.parseInt(br.readLine());
      int []students = new int[n*n];
      boolean [][]like = new boolean[n*n+1][n*n+1];
      int [][] map = new int[n][n];
      for(int i=0;i<n*n;i++) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          int s = Integer.parseInt(st.nextToken());
          students[i] = s;
          while(st.hasMoreTokens()) {
              int a = Integer.parseInt(st.nextToken());
              like[s][a] = true;
          }
      }
      map[1][1] = students[0];
        for(int i=1;i<n*n;i++) {
            int cur_std = students[i];
            int max_like = -1;
            int max_empty = -1;
            int x=0,y=0;
            for (int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    int like_cnt = 0;
                    int empty_cnt = 0;
                    if(map[j][k] != 0)
                        continue;
                    for(int m=0;m<4;m++)
                    {
                        int ny = j + dy[m];
                        int nx = k + dx[m];
                        for(int l=1;l<=n*n;l++)
                        {
                            if(nx>=0 && ny>=0 && nx< n && ny< n && map[ny][nx] == l && like[cur_std][l])
                                like_cnt++;
                        }
                        if(nx>=0 && ny>=0 && nx< n && ny< n && map[ny][nx] == 0)
                            empty_cnt++;
                    }
                    if (like_cnt == max_like && empty_cnt > max_empty) {
                        y= j;
                        x= k;
                        max_empty =empty_cnt;
                    }
                    else if (like_cnt > max_like)
                    {
                      y= j;
                      x= k;
                      max_like = like_cnt;
                      max_empty = empty_cnt;
                    }
                }
            }
            map[y][x] = cur_std;
        }
        int answer = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int cur_std = map[i][j];
                int good = 0;
                for(int l=0;l<4;l++) {
                    int nx = j + dx[l];
                    int ny = i + dy[l];
                    for (int k = 1; k <= n * n; k++) {
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == k && like[cur_std][k]) {
                            if (good == 0)
                                good = 1;
                            else
                                good *= 10;
                        }
                    }
                }
                answer += good;
            }
        }
        System.out.println(answer);
    }
}
