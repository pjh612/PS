package java.P1725;


    import java.io.*;
    import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {
            int n = Integer.parseInt(br.readLine());
            int []arr= new int[n];
            Stack<Integer> st = new Stack<>();
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(br.readLine());
            int ans = 0 ;
            for(int i=0;i<n;i++)
            {
                while(!st.empty() && arr[st.peek()] >= arr[i])
                {
                    int height = arr[st.pop()];
                    int width = st.empty() ? i : i -1 - st.peek();
                    ans = Math.max(ans, height * width);
                }
                st.add(i);
            }
            while(!st.empty())
            {
                int height = arr[st.pop()];
                int width = st.empty() ? n : n - 1 - st.peek();
                ans = Math.max(ans, height * width);
            }
            bw.write(Integer.toString(ans));
            bw.flush();
        }
    }
