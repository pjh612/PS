import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T;
       T= Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++)
        {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j=0;j<n;j++) {
                arr[j] = Integer.parseInt(br.readLine());
               
            }
            Arrays.sort(arr);
            int t1=-987654321,t2=-987654321;

            for(int j=0;j<n;j++)
            {
                if(arr[j] < l/2)
                {
                    t1=Math.max(t1,arr[j]);

                }
                else
                {
                    t1 =Math.max(t1,l-arr[j]);
                }
                if(arr[j] < l/2)
                {
                    t2=Math.max(t2,l-arr[j]);

                }
                else
                {
                    t2 =Math.max(t2,arr[j]);
                }
            }
            bw.write(Integer.toString(t1)+" "+Integer.toString(t2)+"\n");
            bw.flush();
        }


    }


}
