package java.P10472;

import java.io.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char [][]arr;
    static char [][]board;
    static int []dx = {0,1,0,-1};
    static int []dy = {1,0,-1,0};
    static int ans;
    static void rev(int x,int y)
    {
        if(board[y][x] =='*')
            board[y][x] = '.';
        else
            board[y][x] = '*';
        for(int i=0;i<4;i++)
        {
            int nx =dx[i]+ x;
            int ny = dy[i] +y;
            if(nx>2 ||ny >2 || nx <0 || ny <0)
                continue;
            if(board[ny][nx] =='*')
                board[ny][nx] = '.';
            else
                board[ny][nx] = '*';
        }


    }
    static boolean check()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(arr[i][j] != board[i][j])
                    return false;
            }
        }
        return true;
    }
    static void solution(int x,int y,int cnt)
    {
        if(check())
        {
            ans = Math.min(cnt,ans);
        }
        if(x > 2 || y >2 || x <0 || y <0)
            return;
        if(x==2) {
           rev(x,y);
            solution(0,y+1,cnt+1);
            rev(x, y);
            solution(0,y+1,cnt);
        }
        else {
            rev(x, y);
            solution(x + 1, y, cnt + 1);
            rev(x, y);
            solution(x + 1, y, cnt);
        }

    }
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++)
        {
            board = new char[3][3];
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    board[j][k] = '.';
                }
            }

            ans =987654321;
        arr = new char[3][3];
            for(int j=0;j<3;j++)
            {
                String s = br.readLine();
                for(int k=0;k<3;k++)
                {
                    arr[j][k] = s.charAt(k);
                }
            }
            solution(0,0,0);
            bw.write(Integer.toString(ans)+"\n");
            bw.flush();
        }
    }

}
