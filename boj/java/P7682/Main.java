package java.P7682;

import java.io.*;
import java.util.Vector;


public class Main {
    static Vector<Character> v = new Vector();
    static int xc,oc;
    static char g_t;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


       while(true)
       {
           String s = br.readLine();
           if(s.equals("end"))
               break;
           System.out.println(checkValid(s) ? "valid" : "invalid");
       }

    }
    static boolean checkBingo1(int x,int y,int cnt ,char[][] arr,char c) {
        boolean ret = false;
        if (cnt == 2) {
            return true;
        }
        if(y+1 <=2 && arr[y+1][x] == c)
        {
            ret = checkBingo1(x,y+1,cnt+1, arr,c);
        }
        return ret;
    }


    static boolean checkBingo2(int x,int y,int cnt ,char[][] arr,char c) {
        boolean ret = false;
        if (cnt == 2) {
            return true;
        }
        if (x + 1 <= 2 && arr[y][x+1] == c) {
            ret = checkBingo2(x + 1, y, cnt + 1, arr, c);
        }
        return ret;
    }
    static boolean checkBingo3(int x,int y,int cnt ,char[][] arr,char c) {
        boolean ret = false;
        if (cnt == 2) {
            return true;
        }
        if(x+1 <=2 && y+1<=2 && arr[y+1][x+1] == c)
        {
            ret = checkBingo3(x+1,y+1,cnt+1, arr,c);
        }
        return ret;
    }
    static boolean checkBingo4(int x,int y,int cnt ,char[][] arr,char c) {
        boolean ret = false;
        if (cnt == 2) {
            return true;
        }
        if(x+1 <=2 && y-1>=0 && arr[y-1][x+1] == c)
        {
            ret = checkBingo4(x+1,y-1,cnt+1, arr,c);
        }
        return ret;
    }

    static boolean checkValid(String s)
    {
        int check_x =0,check_o=0;
       char[][] arr = new char[3][3];

        for(int i = 0 ;i<3;i++)
        {
            for(int j=0;j<3;j++) {
                arr[i][j] = s.charAt(i * 3 + j);
                if (arr[i][j] == 'X')
                    check_x++;
                if (arr[i][j] == 'O')
                    check_o++;
            }
        }
        boolean o_win =false;
        boolean x_win =false;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(arr[i][j] !='.' && checkBingo1(j,i,0,arr,arr[i][j]) || checkBingo2(j,i,0,arr,arr[i][j]) || checkBingo3(j,i,0,arr,arr[i][j])
                ||checkBingo4(j,i,0,arr,arr[i][j])) {
                    if(arr[i][j] == 'X')
                        x_win=true;
                    else if(arr[i][j] == 'O')
                        o_win = true;
                }
            }
        }
        if(o_win && x_win)
            return false;
        if(x_win && check_x- check_o == 1)
            return true;
        if(o_win && check_x == check_o)
            return true;
        if(!o_win && !x_win && check_x == 5 && check_o == 4)
            return true;
        return false;
    }
}
