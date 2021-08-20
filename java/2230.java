
    import java.io.*;
    import java.lang.reflect.Array;
    import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(Integer.parseInt(br.readLine()));
            Collections.sort(list);
            int l =0, r= 0;
            int min = 2100000000;
            while(l<=r)
            {
                if(r+1 <n && list.get(r) - list.get(l) <m)
                    r++;
              else
                    l++;
                if(l < n && list.get(r)-list.get(l)>=m)
                    min = Math.min(list.get(r) - list.get(l),min);
            }

            bw.write(Integer.toString(min));
            bw.flush();
        }

    }
