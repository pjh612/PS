package java.P18114;

    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {
            int n,c;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int [] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int l = 0, r = n-1;

            while(l<= r)
            {
                int mid =(l+r)/2;
                if(arr[mid] > c)
                {
                    r= mid - 1;
                }
                else if( arr[mid] == c)
                {
                    bw.write("1");
                    bw.flush();
                    return ;
                }
                else
                    l = mid + 1;
            }
            for(int i=0;i<n;i++)
            {
                int val = 0;
                if(arr[i] < c) {
                    val = c - arr[i];
                    l = i+1;
                    r = n - 1;
                    while (l <= r) {
                        int mid = (l + r) / 2;
                        if (arr[mid] > val) {
                            r = mid - 1;
                        } else if (arr[mid] == val) {
                            bw.write("1");
                            bw.flush();
                            return;
                        } else
                            l = mid + 1;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    int val = 0;
                    if(arr[i] + arr[j] < c)
                    {
                        val =c - arr[i]- arr[j];
                        l = j+1;
                        r = n - 1;
                        while (l <= r) {
                            int mid = (l + r) / 2;
                            if (arr[mid] > val) {
                                r = mid - 1;
                            } else if (arr[mid] == val) {
                                bw.write("1");
                                bw.flush();
                                return;
                            } else
                                l = mid + 1;
                        }
                    }
                }
            }
            bw.write("0");
            bw.flush();

        }

    }
