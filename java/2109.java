import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {


    static int []p= new int [10001];
    static int []d= new int [10001];
    static Vector<Integer> []v = new Vector[10001];
    static boolean []visit= new boolean[10001];
    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Pair implements Comparable<Pair>
    {
        public int a,b;
        public Pair(int a, int b)
        {
            this.a=a;
            this.b=b;
        }
        @Override
        public int compareTo(Pair target) {
           if(a == target.a)
           {
               return b > target.b? 1:-1;
           }
           else
               return a > target.a?1:-1;
        }
    }
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=1;i<=10000;i++)
          v[i] = new Vector<Integer>();
        for(int i=0;i<n;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());

            v[d[i]].add(p[i]);
        }

        int ans = 0;
        for(int i=1;i<=10000;i++)
        Collections.sort(v[i],Collections.reverseOrder());
        for(int i=10000;i>=1;--i)
        {
            if(!visit[i]) {
                visit[i] = true;
                for (int j = 0; j < v[i].size(); j++) {
                    pq.add(new Pair(-v[i].get(j).intValue(), i));
                }
                if(pq.isEmpty())
                    continue;

                int pay = pq.peek().a;
                int day = pq.peek().b;
                ans+= -pay;
                pq.poll();
            }

        }
        bw.write(Integer.toString(ans));
        bw.flush();

    }

}
