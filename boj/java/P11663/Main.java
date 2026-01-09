package java.P11663;

    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int [] arr = new int[100001];
        static int [] d = new int[100001];
        public static void main(String[] args) throws IOException {
            int n,m;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++)
            {
                int a = Integer.parseInt(st.nextToken());
                arr[a] = 1;
                d[a] = 1;
            }
            for(int i=1;i<100001;i++)
            {
                if(arr[i] ==1)
                    d[i] =Math.max(d[i-1]+1,d[i]);
                else
                    d[i] = Math.max(d[i-1],d[i]);
            }
            for(int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                bw.write(Integer.toString(d[e] - d[s-1])+"\n");
            }
            bw.flush();
        }

    }
