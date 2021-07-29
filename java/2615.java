import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static int[][] arr = new int[20][20];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int i=0;i<19;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<19;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
     for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++)
            {
                if(arr[i][j] ==0 )
                    continue;
                if(func1(j,i,1,arr[i][j]) || func2(j,i,1,arr[i][j]) || func3(j,i,1,arr[i][j]) ||func4(j,i,1,arr[i][j]))
                {

                    bw.write(Integer.toString(arr[i][j]) +"\n" +  Integer.toString(i+1) +" " + Integer.toString(j+1));
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(Integer.toString(0));
        bw.flush();
    }
    public static boolean func1(int x, int y,int cnt,int color)
    {
        boolean ret =false;
        if(cnt == 5) {
            if(x +1 <=18 &&arr[y][x+1]==color)
                return false;
            return true;
        }
        if(cnt== 1 &&x -1 >=0 &&arr[y][x-1]==color)
            return false;
        if(x +1 <=18 &&arr[y][x+1]==color)
            ret = func1(x+1,y,cnt+1,color);
        return ret;
    }
    public static boolean func2(int x, int y,int cnt,int color)
    {
        boolean ret =false;
        if(cnt == 5) {
            if(y+1 <=18 &&arr[y+1][x]==color)
                return false;
            return true;
        }
        if(cnt== 1 &&y-1 >=0 &&arr[y-1][x]==color)
            return false;
        if(y+1 <=18 &&arr[y+1][x]==color)
            ret = func2(x,y+1,cnt+1,color);
        return ret;
    }
    public static boolean func3(int x, int y,int cnt,int color)
    {
        boolean ret =false;
        if(cnt == 5) {
            if((x + 1<=18) && (y+1 <=18) &&(arr[y+1][x+1]==color))
                return false;
            return true;
        }
        if(cnt== 1 &&(x -1>=0) && (y-1 >=0) &&(arr[y-1][x-1]==color))
            return false;
        if((x + 1<=18) && (y+1 <=18) &&(arr[y+1][x+1]==color))
            ret = func3(x+1,y+1,cnt+1,color);
        return ret;
    }
    public static boolean func4(int x, int y,int cnt,int color)
    {
        boolean ret =false;
        if(cnt == 5) {

            if(x + 1 <= 18 && y-1 >=0 &&arr[y-1][x+1]==color)
                return false;
            return true;
        }
        if(cnt== 1 &&x-1 >=0 && y+1 <=18 && arr[y+1][x-1]==color)
            return false;
        if(x + 1 <= 18 && y-1 >=0 &&arr[y-1][x+1]==color)
            ret = func4(x+1,y-1,cnt+1,color);
        return ret;
    }


}
