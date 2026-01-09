package java.P21599;


    import java.io.*;
    import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {
            List<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++)
            {
                int a = Integer.parseInt(st.nextToken());
                list.add(a);
            }
            Collections.sort(list,Comparator.reverseOrder());
            int ans =0;
            for(int i= 0;i<list.size();i++)
            {
                if(list.get(i) ==0)
                    continue;
                if(i +list.get(i)-1> ans)
                    ans = i+list.get(i)-1;
            }
            if(list.get(0) == 0)
                bw.write("0");
            else {
                if(ans+1 > list.size())
                    bw.write(Integer.toString(list.size()));
                else
                bw.write(Integer.toString(ans + 1));
            }
            bw.flush();
        }
    }
