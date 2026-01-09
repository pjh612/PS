import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    static boolean[] select = new boolean[27];
    static HashMap<String, Integer> cnt = new HashMap<>();
    static List<String>[] list = new ArrayList[11];

    static class Entity implements Comparable<Entity> {
        String s;
        int cnt;

        public Entity(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Entity o) {
            return o.cnt - this.cnt;
        }
    }

    static void solve(int cur, int max, int idx, String str) {
        if (cur == max) {
            int c = 0;
            String s = "";
            for (int i = 0; i <= 26; i++) {
                if (select[i]) {
                    s += (char) ('A' + i);
                    c++;
                }
            }
            if (c == max) {
                if (cnt.containsKey(s))
                    cnt.put(s, cnt.get(s) + 1);
                else {
                    cnt.put(s, 1);
                    list[max].add(s);
                }
            }
            return;

        }

        for (int i = idx; i < str.length(); i++) {
            if (!select[str.charAt(i) - 'A']) {
                select[str.charAt(i) - 'A'] = true;
                solve(cur + 1, max, i + 1, str);
                select[str.charAt(i) - 'A'] = false;
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < course.length; i++)
            list[course[i]] = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                solve(0, course[i], 0, orders[j]);
            }
            ArrayList<Entity> cnts = new ArrayList<>();
            for (int j = 0; j < list[course[i]].size(); j++) {
                if (cnt.get(list[course[i]].get(j)) >= 2) {
                    cnts.add(new Entity(list[course[i]].get(j), cnt.get(list[course[i]].get(j))));
                }
            }
            Collections.sort(cnts);
            if (!cnts.isEmpty()) {
                int max = cnts.get(0).cnt;
                ans.add(cnts.get(0).s);
                for (int j = 1; j < cnts.size(); j++) {
                    if (cnts.get(j).cnt != max)
                        break;
                    ans.add(cnts.get(j).s);
                }
            }

        }
        Collections.sort(ans);
        String[] answer = ans.toArray(new String[0]);

        return answer;
    }
}