package java.P16564;

    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {
            int n,k;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int [] arr = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);
            int l = 1, r = 100000000;

            while(l<= r)
            {
                int mid =(l+r)/2;
                long cnt = 0 ;
                for(int i=0;i<n;i++)
                {
                    if(mid > arr[i])
                        cnt += (mid-arr[i]);
                }
                if(cnt > k)
                {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            bw.write(Integer.toString(r));
            bw.flush();

        }

    }
