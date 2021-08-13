import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int []arrx =new int[105];
	static int []arry = new int[105];
	public static void main(String[] args) throws IOException {
		int T;
		T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			int n = Integer.parseInt(br.readLine());
			int [][]d = new int[105][105];
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrx[0] = Integer.parseInt(st.nextToken());
			arry[0] = Integer.parseInt(st.nextToken());
			for(int j=1;j<=n;j++)
			{
				st = new StringTokenizer(br.readLine());
				arrx[j] = Integer.parseInt(st.nextToken());
				arry[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			arrx[n+1] = Integer.parseInt(st.nextToken());
			arry[n+1] = Integer.parseInt(st.nextToken());
			for(int j=0;j<=n+1;j++)
			{
				for(int k=0;k<=n+1;k++)
				{
					if(j==k)
						d[j][k] =0 ;
					else if(Math.abs(arrx[j] - arrx[k]) + Math.abs(arry[j] - arry[k]) <=1000)
					d[j][k] = Math.abs(arrx[j] - arrx[k]) + Math.abs(arry[j] - arry[k]);
					else
					d[j][k] =987654321;
				}
			}
			for(int j=0;j<n+1;j++)
			{
				for(int k=0;k<=n+1;k++)
				{
					for(int l=0;l<=n+1;l++)
					{
						if(d[k][j] +d[j][l] < d[k][l]) {
							d[k][l] = d[k][j] + d[j][l];
						}
					}
				}
			}
			if(d[0][n+1] !=987654321)
			{
				bw.write("happy\n");
			}
			else
				bw.write("sad\n");
			bw.flush();
		}


	}
}
