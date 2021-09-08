import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int [] arr = new int[1001];
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		int a_cnt = 0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='a')
				a_cnt++;
		}
		int b_cnt=0;
		for(int i=0;i<a_cnt;i++)
		{
			if(s.charAt(i) == 'b')
				b_cnt++;
		}
		int ans = b_cnt;
		for(int i=1;i<s.length();i++)
		{
			if(s.charAt(i-1)=='b')
			{
				b_cnt--;
			}
			int r =i+a_cnt-1;
			if(r >=s.length())
			{
				r-=s.length();
			}
			if(s.charAt(r) == 'b')
				b_cnt++;
			ans = Math.min(ans, b_cnt);
		}
		System.out.println(ans);
	}

}


