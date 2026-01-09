package P120956_옹알이_1;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            String replace = str.replaceAll("(aya|ye|woo|ma)", "");

            if(replace.trim().isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}