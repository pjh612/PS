package java.P20055;

    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int []hp=  new int [2*n];
            int []is_robot=  new int [2*n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<2*n;i++)
            {
                hp[i] = Integer.parseInt(st.nextToken());
            }
            Queue<Integer> q = new LinkedList<>();
            int cnt = 0;
            while(k>=1) {
                cnt++;
                int tmp = hp[2 * n - 1];
                for (int i = 2 * n - 1; i >= 1; i--) {
                    hp[i] = hp[i - 1];
                }
                hp[0] = tmp;
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    int cur = q.poll();
                    int next_pos = 0;
                    is_robot[cur] = 0;
                    if (cur + 1 == 2 * n)
                        next_pos = 0;
                    else
                        next_pos = cur + 1;
                    if(next_pos == n-1)
                        continue;
                    q.add(next_pos);
                    is_robot[next_pos] = 1;
                }
                len = q.size();
                for (int i = 0; i < len; i++) {
                    int cur = q.poll();
                    is_robot[cur] = 0;
                    int next_pos = 0;
                    if (cur + 1 != 2 * n)
                        next_pos = cur + 1;

                    if (is_robot[next_pos] != 1 && hp[next_pos] >= 1) {
                        hp[next_pos]--;
                        if(hp[next_pos]==0)
                            k--;
                        if(next_pos == n-1)
                            continue;
                        q.add(next_pos);
                        is_robot[next_pos] = 1;

                    }
                    else
                    {
                        is_robot[cur] =1;
                        q.add(cur);
                    }
                }
                if (hp[0] != 0) {
                    q.add(0);
                    is_robot[0] = 1;
                    hp[0]--;
                    if(hp[0] == 0)
                        k--;
                }
                int check = 0;

            }
            bw.write(Integer.toString(cnt));
            bw.flush();
        }
    }
