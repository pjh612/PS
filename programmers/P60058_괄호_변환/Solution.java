package P60058_괄호_변환;

class Solution {
    public String solution(String p) {
        return repair(p);
    }

    private String repair(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int openCnt = 0;
        int closeCnt = 0;

        String u = "";
        String v = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCnt++;
            } else {
                closeCnt++;
            }

            if (openCnt == closeCnt) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1);
                break;
            }
        }

        if (isValid(u)) {
            return u + repair(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(")
                    .append(repair(v))
                    .append(")");

            StringBuilder sb2 = new StringBuilder(u.substring(1, u.length() - 1));
            for (int i = 1; i < u.length() - 1; i++) {
                sb.append(u.charAt(i) == ')' ? '(' : ')');
            }


            return sb.toString();
        }
    }


    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }

        return true;
    }

    private boolean isBalanced(String s) {
        int openCnt = 0, closeCnt = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCnt++;
            } else {
                closeCnt++;
            }
        }

        if (openCnt == closeCnt) {
            return true;
        }

        return false;
    }
}

