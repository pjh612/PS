package java.P9935;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	static Stack<Pair> st= new Stack<Pair>();

	public static class Pair
	{
		int cnt;
		char a;
		public Pair(int cnt , char a)
		{
			this.cnt = cnt;
			this.a = a;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String bomb = br.readLine();
		ArrayList<Character> ans = new ArrayList<>();
		for(int i=0;i<s.length();i++)
		{
			char now = s.charAt(i);
			ans.add(now);
			if (now == bomb.charAt(bomb.length()-1))
			{
				int cnt=0;
				int k =0 ;
				for(int j= bomb.length()-1;j>=0;j--)
				{
					if(ans.size() -1-k<0)
						break;
					if(ans.get(ans.size() -1-k) == bomb.charAt(j))
						cnt++;
					k++;
				}
				if(cnt==bomb.length())
				{
					for(int j=0;j<bomb.length();j++)
					{
						ans.remove(ans.size()-1);
					}
				}
			}



		}
		if(ans.isEmpty())
			bw.write("FRULA");
		for(int i=0;i<ans.size();++i)
		{
			bw.write(Character.toString(ans.get(i)));
		}
		bw.flush();
	}
}
