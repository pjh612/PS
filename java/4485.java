
    import java.io.*;
    import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static class Entity implements Comparable<Entity> {
            int cost;
            int x,y;

            public Entity(int cost, int x, int y) {
                this.cost = cost;
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Entity o) {
                if(this.cost == o.cost)
                {
                    if(this.x == o.x)
                        return this.y- o.y;
                    else
                        return this.x-o.x;
                }
                else
                    return this.cost-o.cost;
            }
        }
        static int[] dx={0,1,0,-1};
        static int[] dy = {1, 0, -1, 0};
        static int[][] arr =new int [126][126];
        static int[][] d =new int [126][126];
        public static void main(String[] args) throws IOException {
            int t = 0;
           while(true){
               int n = Integer.parseInt(br.readLine());
               if(n == 0 )
                   break;
               for(int i=0;i<n;i++) {
                   for(int j=0;j<n;j++)
                       d[i][j] = 987654321;

               }
               for(int i=0;i<n;i++)
               {
                   StringTokenizer st = new StringTokenizer(br.readLine());
                   for(int j=0;j<n;j++)
                   {
                       arr[i][j] = Integer.parseInt(st.nextToken());
                   }
               }
               PriorityQueue<Entity> pq = new PriorityQueue<>();
               pq.add(new Entity(arr[0][0], 0, 0));
               d[0][0] =arr[0][0];
               while(!pq.isEmpty())
               {
                   int cur_x = pq.peek().x;
                   int cur_y = pq.peek().y;
                   int cur_cost = pq.peek().cost;
                   pq.poll();
                   if(cur_cost > d[cur_y][cur_x])
                       continue;
                   for(int i=0;i<4;i++)
                   {
                       int nx = cur_x+dx[i];
                       int ny = cur_y+dy[i];
                       if(nx>=n || ny>=n || nx<0 ||ny< 0)
                           continue;
                       int next_cost = cur_cost + arr[ny][nx];
                       if(next_cost < d[ny][nx])
                       {
                           d[ny][nx] = next_cost;
                           pq.add(new Entity(next_cost,nx,ny));
                       }
                   }
               }
               bw.write("Problem " + (++t) + ": " + Integer.toString(d[n - 1][n - 1])+"\n");

           }
           bw.flush();
        }


    }
