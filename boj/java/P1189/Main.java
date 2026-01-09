package java.P1189;

import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean [][]visit;
    static char [][]board;
    static int []dx = {0,1,0,-1};
    static int []dy = {1,0,-1,0};
    static int r,c,k;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[r+1][c+1];
        visit = new boolean[r+1][c+1];
        for(int i=0;i<r;i++)
            board[i] = br.readLine().toCharArray();
        visit[r-1][0] = true;
        System.out.println(solution(0, r - 1, 1, k));

    }
    static int solution(int x,int y,int dis,int k)
    {
        int ret =0 ;
        if(dis == k && x == c-1 && y == 0)
        {
            return 1;
        }
        for(int i=0;i<4;i++)
        {
            int nx = x+dx[i];
            int ny= y+dy[i];
            if(nx >=0 && ny >=0 && nx < c && ny <r && !visit[ny][nx] &&board[ny][nx] != 'T')
            {
                visit[ny][nx] = true;
                ret += solution(nx,ny,dis + 1,k);
                visit[ny][nx] = false;
            }
        }
        return ret;
    }

}
