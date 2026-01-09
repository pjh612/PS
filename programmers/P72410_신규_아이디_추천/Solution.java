package P72410_신규_아이디_추천;
class Solution {
    public String solution(String new_id) {
        String filtered = new_id.toLowerCase()
                .chars()
                .filter(this::isAllowed)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();



        StringBuilder sb = new StringBuilder();
        char prev = 0;
        for (char c : filtered.toCharArray()) {
            if (prev == '.' && c == '.') {
                continue;
            }

            sb.append(c);
            prev = c;
        }

        trimDot(sb);

        if(sb.length() ==0) {
            sb.append('a');
        }

        if(sb.length() >= 16) {
            sb.setLength(15);
        }

        trimDot(sb);


        char c = sb.charAt(sb.length() - 1);
        while(sb.length() <= 2) {
            sb.append(c);
        }


        return sb.toString();

    }

    private boolean isAllowed(int c) {
        return (c == '-' || c == '_' || c == '.' || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }

    private void trimDot(StringBuilder sb) {
        if (sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
    }
}