import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int []arr;
    static long []segTree;

    static double baseLog(double x, double base) {
        return Math.log(x) / Math.log(base);
    }

    static long make_seg(int node , int start, int end)
    {
        if(start == end)
            return segTree[node] = arr[start];
        segTree[node] =(make_seg(node * 2, start , (start + end) / 2) *
        make_seg(node * 2 + 1, (start+end)/2 + 1 , end) ) % 1000000007;
        return segTree[node];
    }

    static long find(int node, int start , int end , int left, int right)
    {
        if(end < left || right < start)
            return 1;
        if(left<= start && end <= right)
            return segTree[node];
        long ret = (find(node * 2, start, (start + end) / 2, left, right) * find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)) % 1000000007;
        return ret;
    }

    static long update_seg(int node, int start, int end, int idx,int to)
    {
        if(idx < start || idx > end) {
            return segTree[node];
        }
        if(start == end) {
            return segTree[node] = to;

        }
        segTree[node] = (update_seg(node * 2 ,start, (start+end) / 2 , idx, to)*
        update_seg(node * 2 + 1, (start+end) / 2 + 1, end , idx,to))% 1000000007;
        return segTree[node];
    }
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int treeHeight = (int) Math.ceil(baseLog(n,2));
        int treeSize = (int) Math.pow(2,treeHeight+1);
        arr = new int[n+2];
        for(int i=0;i<n;i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        segTree = new long[treeSize+2];
        make_seg(1,0,n-1);

        for(int i=0;i<m+k;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1)
            {
                update_seg(1,0,n-1, b-1,c);
            }
            else {
            bw.write(find(1,0,n-1,b-1,c-1) %1000000007 +"\n");
                bw.flush();
            }

        }


    }

}
