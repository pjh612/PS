package java.P22857;

    import java.io.*;
    import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static int [] presum= new int [50001];
        static int []arr = new int [50001];
        public static void main(String[] args) throws IOException {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            presum[0] = arr[0] %2 ==0? 0 :1;
            for(int i=1;i<n;i++)
            {
                if(arr[i]%2 ==0) {
                 presum[i] = presum[i-1];
                }
                else
                    presum[i] = presum[i-1] + 1;
            }
            int ans = 0;
            for(int i=0;i<n;i++)
            {
                int l = 0, r= i;
                while(l<=r)
                {
                    int mid = (l+r)/ 2;
                    int cnt;
                    if(mid ==0)
                        cnt = presum[i];
                    else
                        cnt = presum[i] -presum[mid-1];
                    if(cnt <= k)
                    {
                        r= mid - 1;
                    }
                    else
                        l= mid+1;
                }
                int left = r+1;
                if(left==0)
                    ans = Math.max(ans, i - left + 1 -presum[i]);
                else
                    ans = Math.max(ans, i-left + 1 -(presum[i]- presum[r]));
            }
            bw.write(Integer.toString(ans));
            bw.flush();

        }
    }
