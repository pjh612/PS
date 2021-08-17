    import java.io.*;
    import java.util.PriorityQueue;
    import java.util.Stack;
    import java.util.StringTokenizer;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static class Pair implements Comparable<Pair>
        {
            int x,r;
            public Pair(int x, int r)
            {
                this.x =x;
                this.r =r;
            }

            @Override
            public int compareTo(Pair o) {
                if(this.r ==o.r)
                {
                    return this.x-o.x;
                }
                else
                    return o.r- this.r;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "x=" + x +
                        ", r=" + r +
                        '}';
            }
        }


        public static void main(String[] args) throws IOException {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            Stack<Pair> stack = new Stack<>();
            for(int i=0;i<n;i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                pq.add(new Pair(x, r));

            }
            stack.push(pq.poll());
            while (!pq.isEmpty()) {
                int tx = stack.peek().x;
                int tr =stack.peek().r;
                int x = pq.peek().x;
                int r = pq.peek().r;
                if(r+tr<Math.abs(x-tx) || Math.abs(x-tx)< Math.abs(r-tr))
                {
                    stack.add(pq.poll());
                }
                else
                {
                    bw.write("NO");
                    bw.flush();
                    return ;
                }
            }
            bw.write("YES");
            bw.flush();
        }
    }
