import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			left.add(s.charAt(i));
		}
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			if (cmd.equals("L")) {
				if (!left.empty()) {
					right.add(left.pop());
				}
			} else if (cmd.equals("D")) {
				if (!right.empty())
					left.add(right.pop());
			} else if (cmd.equals("B")) {
				if (!left.empty()) {
					left.pop();
				}
			} else {
				left.add(cmd.charAt(2));
			}
		}
		while (!left.empty()) {
			right.add(left.pop());
		}

		while (!right.empty())
			bw.write(right.pop());
		bw.flush();

	}
	}


