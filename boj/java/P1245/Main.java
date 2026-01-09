package java.P1245;

import java.io.*;
import java.util.StringTokenizer;
public class Main {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int [][]arr= new int[101][101];
	static boolean [][]visit= new boolean[101][101];
	static int []dx = {1,0,0,-1,1,1,-1,-1};
	static int []dy ={0,1,-1,0,1,-1,1,-1};
	static int n,m;
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());

			for(int j=0;j<m;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans =0 ;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++) {
				if(!visit[i][j] &&!dfs(j, i, arr[i][j]))
					ans++;
			}
		}
		bw.write(Integer.toString(ans));
		bw.flush();

	}
	static boolean dfs(int x,int y, int val)
	{
		boolean flag= false;
		for(int i=0;i<8;i++)
		{
			int nx= x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx< m && ny <n) {
				if(arr[ny][nx] > val)
					flag= true;
			}
			if(nx>=0 && ny>=0 && nx< m && ny <n && !visit[ny][nx] && arr[ny][nx] == val) {
				visit[ny][nx] = true;
				boolean ret = dfs(nx, ny, val);
				if(flag == false && ret ==true)
					flag=true;
			}
		}
		return flag;
	}

}
