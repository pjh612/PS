package P72410_신규_아이디_추천;
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        char[] charArray = new_id.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c == '-' || c == '_' || c == '.' || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }

        String tmp = sb.toString();
        sb = new StringBuilder();
        char prev = 0;
        for (char c : tmp.toCharArray()) {
            if (prev == '.' && c == '.') {
                continue;
            }

            sb.append(c);
            prev = c;
        }

        if(sb.length() >=1 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }

        if(sb.length() >= 1 && sb.charAt(sb.length()-1) == '.') {
            sb.deleteCharAt(sb.length()-1);
        }

        if(sb.length() ==0) {
            sb.append('a');
        }

        if(sb.length() >= 16) {
            sb.setLength(15);
        }

        if(sb.charAt(sb.length()-1) == '.') {
            sb.deleteCharAt(sb.length()-1);
        }

        if(sb.length() <= 2) {
            char c = sb.charAt(sb.length() - 1);
            while(sb.length() <= 2) {
                sb.append(c);
            }
        }

        return sb.toString();

    }
}