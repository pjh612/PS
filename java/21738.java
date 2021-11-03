    import java.io.*;

    import java.util.*;


    public class Main {

        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        static int []visit;
        public static void main(String[] args) throws IOException {

            Queue<Integer> q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            List<Integer> []map = new ArrayList[n+1];
            visit = new int[n+1];
            for(int i=1;i<=n;i++)
            {
                map[i] = new ArrayList<>();
            }
            Arrays.fill(visit, -1);
            for(int i=0;i<n-1;i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a].add(b);
                map[b].add(a);
            }
            q.add(p);
            visit[p] = 0;
            int dis = 0;
            int cnt = 0;
            while(!q.isEmpty())
            {
                int cur = q.poll();

                if(1<= cur && cur <=s)
                {
                    dis +=visit[cur];
                 //   System.out.println(visit[cur]);
                    cnt++;
                    if(cnt == 2)
                        break;
                }
                for(int i=0;i<map[cur].size();i++)
                {
                    int next = map[cur].get(i);
                    if(visit[next] == -1)
                    {
                        q.add(next);
                        visit[next] = visit[cur]+ 1;
                    }
                }
            }
            System.out.println(n-dis - 1);
        }
    }