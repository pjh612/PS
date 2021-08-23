    import java.io.*;
    import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static class Entity
        {
            int cnt;
            int pos;

            public Entity(int cnt, int pos) {
                this.cnt = cnt;
                this.pos = pos;
            }
        }
        static int []visit = new int [100001];
        static int []cnt = new int [100001];
        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Queue<Entity> q = new LinkedList<>();
            q.add(new Entity(0,n));
            int min =987654321;
            int min_cnt =987654321;
            while(!q.isEmpty())
            {
                int cur_pos = q.peek().pos;
                int cur_cnt =  q.peek().cnt;
                q.poll();
                if(cur_pos ==k && min_cnt == 987654321) {
                    min_cnt = 1;
                    min = cur_cnt;
                }
                else if(cur_pos== k && cur_cnt == min)
                    min_cnt++;
                visit[cur_pos] = 1;
                if( cur_pos + 1 <= 100000 && visit[cur_pos +1] ==0 ) {
                    q.add(new Entity(cur_cnt + 1,cur_pos + 1));
                }
                if( cur_pos -1 >=0 && visit[cur_pos - 1] ==0 ) {
                    q.add(new Entity(cur_cnt + 1,cur_pos - 1));
                }
                if(cur_pos *2 <=100000&&visit[cur_pos * 2] == 0 ) {
                    q.add(new Entity(cur_cnt + 1,cur_pos * 2));
                }

            }
            bw.write(Integer.toString(min) + "\n" + Integer.toString(min_cnt));
            bw.flush();

        }
    }
