    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {
            int n, m;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            Map<String, Boolean> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(br.readLine(), true);
            }
            int cnt = n;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), ",");

                while (st.hasMoreTokens()) {
                    String s = st.nextToken();
                    if (map.containsKey(s)) {
                        map.remove(s);
                        cnt--;
                    }
                }
                bw.write(cnt + "\n");
            }
            bw.flush();
        }
    }