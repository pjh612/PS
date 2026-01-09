package P49993_스킬트리;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            boolean[] flags = new boolean[26];

            for (char c : skill.toCharArray()) {
                flags[c - 'A'] = true;
            }

            int i = 0;
            int j = 0;

            boolean valid = true;

            while (i < skill.length() && j < skill_tree.length()) {
                char current = skill_tree.charAt(j);
                if (flags[current - 'A']) {
                    if (skill.charAt(i) == current) {
                        i++;
                    } else {
                        valid = false;
                        break;
                    }
                }

                j++;
            }

            if (valid) {
                answer++;
            }
        }

        return answer;
    }
}
