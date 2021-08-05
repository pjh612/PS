import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
	세그먼트 트리 연습
 */
public class Main {

	static int minSegTree[];
	static int maxSegTree[];
	static int arr[];

	static double logB(double x, double base) { return Math.log(x)/Math.log(base); }

	static int make_MinSeg(int node, int start, int end)
	{
		if(start == end)
			return minSegTree[node] = arr[start];
		minSegTree[node] =Math.min(make_MinSeg(node * 2,start, (start + end)/2), make_MinSeg(node * 2 + 1,(start+end)/2+1,end));
		return minSegTree[node];
	}

	static int make_MaxSeg(int node, int start, int end)
	{
		if(start == end)
			return maxSegTree[node] = arr[start];
		maxSegTree[node] =Math.max(make_MaxSeg(node * 2,start, (start + end)/2), make_MaxSeg(node * 2 + 1,(start+end)/2+1,end));
		return maxSegTree[node];
	}

	static int findMax(int node, int start,int end, int left, int right)
	{
		if(left > end || right < start) return -2147483648;
		if(left<=start && end<= right)
			return maxSegTree[node];
		int max = Math.max(findMax(node*2,start, (start +end)/2, left, right),
			findMax(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
		return max;
	}

	static int findMin(int node, int start,int end, int left, int right)
	{
		if(left > end || right < start) return 2147483647;
		if(left<=start && end<= right)
			return minSegTree[node];
		int min = Math.min(findMin(node*2,start, (start +end)/2, left, right),
			findMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
		return min;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int treeHeight = (int)Math.ceil(logB(n,2));
		int treeSize = (int) Math.pow(2,treeHeight+1);
		arr = new int[n+1];
		minSegTree = new int[treeSize+2];
		maxSegTree = new int[treeSize+2];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(br.readLine());

		}
		make_MinSeg(1,0,n-1);
		make_MaxSeg(1,0,n-1);
		for(int i=0;i<m;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start =  Integer.parseInt(st.nextToken());
			int end =  Integer.parseInt(st.nextToken());
			bw.write(Integer.toString(findMin(1, 0, n-1 ,start-1,end-1)) +" " +
			Integer.toString(findMax(1, 0, n-1 ,start-1,end-1))+"\n");
			bw.flush();

		}

	}

}
