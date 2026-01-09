package P60057_문자열_압축;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;

        List<Integer> list = new ArrayList<>();

        for (int d = 1; d <= length / 2; d++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, d);

            for (int i = d; i <= length; i += d) {
                String current = i + d > length
                        ? s.substring(i)
                        : s.substring(i, i + d);

                if (current.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }

                    sb.append(prev);
                    count = 1;
                }

                prev = current;
            }

            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);
            answer = Math.min(sb.length(), answer);

        }

        return answer;
    }
}