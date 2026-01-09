package java.P6137;

import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];
		char[] t = new char[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().charAt(0);
		}

		int l = 0, r = N - 1, idx = 0;
		while (l <= r) {
			if (arr[l] < arr[r]) {
				t[idx++] = arr[l++];
			} else if (arr[l] > arr[r]) {
				t[idx++] = arr[r--];
			} else {
				int l2 = l, r2 = r;
				boolean flag =false;
				while (l2<=r2) {
					if (arr[l2] < arr[r2]) {
						flag =true;
						t[idx++] = arr[l++];
						break;
					} else if (arr[l2] > arr[r2]) {
						flag =true;
						t[idx++] = arr[r--];
						break;
					}
					else
					{
						l2++;
						r2--;
					}
				}
				if(!flag)
					t[idx++]=arr[l++];
			}
		}
		for(int i=0;i<N;i++) {
			bw.write(t[i]);
			if(i != 0 && (i+1) % 80 ==0)
				bw.write("\n");
		}
		bw.flush();
	}
}


