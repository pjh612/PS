
    import java.io.*;

    import java.util.*;


    public class Main {

        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static class Edge
        {
            int a,c;

            public Edge(int a, int c) {
                this.a = a;
                this.c = c;
            }
        }
        static int []visit= new int [50001];
        static List<Edge> [] map;
        static int diameter;
        static int root;
        static int min_score=0;
        public static void main(String[] args) throws IOException {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            map= new ArrayList[n+1];

            for(int i=1;i<=n;i++)
            {
                map[i] = new ArrayList<>();
            }
            for(int i=0;i<n-1;i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a] .add(new Edge(b,c));
                map[b] .add(new Edge(a,c));

            }
            visit[1] =1;
            dfs(1,1,0);

            Arrays.fill(visit,0);

            diameter = 0;
            min_score = 987654321;
            visit[root] =1;
            dfs(root,1,0);

            int ans = (min_score % t >=1 ? min_score / t + 1 : min_score/t);
            System.out.println(ans);

        }

        static void dfs(int cur,int depth, int score)
        {
            if(depth>diameter)
            {
                diameter=depth;
                root = cur;
                min_score = score;
            }
            if(depth == diameter && score < min_score)
            {
                root= cur;
                min_score = score;
            }
            for(int i=0;i<map[cur].size();i++)
            {
                int next = map[cur].get(i).a;
                if(visit[next] == 1)
                    continue;
                visit[next] = 1;
                dfs(next,depth+1,score+ map[cur].get(i).c);
            }

        }
    }