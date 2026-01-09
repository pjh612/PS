package java.P22945;

    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int []arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int l = 0, r = n-1;
            int ans = 0;
            while(l<=r)
            {
                int min = Math.min(arr[l],arr[r]);
                ans = Math.max((r-l -1) * min, ans);
                if(arr[l] < arr[r])
                    l++;
                else
                    r--;
            }
            System.out.println(ans);
        }
    }
