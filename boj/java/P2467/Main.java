package java.P2467;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int l =0 ,r=n-1;
		int min = 2100000000;
		int al=0,ar=n-1;
		while(l<=r)
		{
			int val = arr[r] + arr[l];
			if(l != r && Math.abs(arr[r] + arr[l])< min)
			{
				al= l;
				ar = r;
				min = Math.abs(val);
			}
			if(val >= 0)
			{
				r--;
			}
			else
			{
				l++;
			}
		}
		System.out.println(arr[al] + " " + arr[ar]);
	}

}


