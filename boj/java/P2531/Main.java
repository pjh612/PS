package java.P2531;


    import java.io.*;
    import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n,d,k,c;
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int []check = new int[d+1];
            Arrays.fill(check,0);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            check[c] = 1;
            int val = 1;
            for(int i=0;i<k;i++)
            {
                if(check[list.get(i)]==0)
                    val++;
                check[list.get(i)] ++;
            }
            int ans = 1;
            for(int i = 0 ;i<n;i++)
            {
                int l = i;
                int r = i + k - 1;
                if(r >=n)
                    r= r-n;
                int nr = r + 1;
                if(nr == n)
                    nr= 0;
                if(check[list.get(nr)] == 0) {
                    val++;
                }
                check[list.get(nr)]++;
                if(check[list.get(l)] == 1) {
                    val--;
                }
                check[list.get(l)]--;

                ans = Math.max(ans,val);
            }
            bw.write(Integer.toString(ans));
            bw.flush();
        }
    }
