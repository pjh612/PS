    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        public static void main(String[] args) throws IOException {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= 15; i++) {
                int num = i;
                String s = "";
                for (int j = 0; j < 4; j++) {
                    s += num % 2;
                    num /= 2;
                }
                String s2 = "";
                for (int j = s.length()-1; j >=0; j--) {
                    if (s.charAt(j) == '0') {
                        s2 += "V";
                    } else
                        s2 += "딸기";
                }

                list.add(s2);
            }

            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int n = Integer.parseInt(br.readLine());
                if (n <= 15) {
                    bw.write(list.get(n-1));

                } else {
                    int n2 = n - 16;
                    int p = n2 / 14;
                    int q = n2 % 14;
                    if (p % 2 == 0) {
                        bw.write(list.get(13 - q));
                    } else {
                        bw.write(list.get(q + 1));
                    }
                }
                bw.write("\n");
                bw.flush();
            }
        }
    }
