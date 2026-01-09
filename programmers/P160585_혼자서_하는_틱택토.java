public class P160585_혼자서_하는_틱택토 {

    public int solution(String[] board) {
        int oCount = 0, xCount = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                }
                if (c == 'O') {
                    oCount++;
                }
            }
        }

        // oCount가 xCount랑 같은데 O 빙고가 아니라면 X승리
        // oCount가 xCount보다 한 개 많은데 X빙고가 아니라면 O승리

        if (oCount < xCount || oCount > xCount + 1) {
            return 0;
        }

        int bingo = whoIsBingo(board);

        boolean oWin = (bingo & 1) != 0;
        boolean xWin = (bingo & 2) != 0;

        if (oWin && xWin) {
            return 0;
        }

        if (oWin && oCount != xCount + 1) {
            return 0;
        }

        if (xWin && oCount != xCount) {
            return 0;
        }

        return 1;

    }

    private int whoIsBingo(String[] board) {
        int ret = 0;

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                if (board[i].charAt(0) == 'O') {
                    ret |= 1;
                } else if (board[i].charAt(0) == 'X') {
                    ret |= 2;
                }
            }

            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'O') {
                    ret |= 1;
                } else if (board[0].charAt(i) == 'X') {
                    ret |= 2;
                }
            }
        }

        if ((board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2))
                || (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0))) {
            if (board[1].charAt(1) == 'O') {
                ret |= 1;
            } else if (board[1].charAt(1) == 'X') {
                ret |= 2;
            }
        }

        return ret;
    }


}
