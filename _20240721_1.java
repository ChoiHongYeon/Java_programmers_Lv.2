// 리코쳇 로봇 (https://school.programmers.co.kr/learn/courses/30/lessons/169199?language=java)
package _20240721_1;
import java.util.*;

class Solution {
    public int solution(String[] board) {

        int start[] = new int[2];
        for (int i = 0; i < board.length; i++) {
            if (board[i].indexOf("R") >= 0) {
                start[0] = board[i].indexOf("R");
                start[1] = i;
                break;
            }
        }

        boolean visited[][] = new boolean[board[0].length()][board.length];
        Deque<Integer> X = new ArrayDeque<>();
        Deque<Integer> Y = new ArrayDeque<>();
        Deque<Integer> steps = new ArrayDeque<>();
        X.addFirst(start[0]);
        Y.addFirst(start[1]);
        steps.addFirst(0);

        while(!X.isEmpty()) {

            int xx = X.removeFirst();
            int yy = Y.removeFirst();
            int s = steps.removeFirst();
            int x;
            int y;

            // 위로 이동
            if (yy > 0) {
                x = xx;
                y = yy;
                for (int i = yy - 1; i >= 0; i--) {
                    if (board[i].charAt(x) == 'D') {
                        y = i + 1;
                        break;
                    } else if (i == 0) {
                        y = i;
                    }
                }
                if (board[y].charAt(x) == 'G')
                    return s + 1;
                if (visited[x][y] == false) {
                    visited[x][y] = true;
                    X.addLast(x);
                    Y.addLast(y);
                    steps.addLast(s + 1);
                }
            }

            // 아래로 이동
            if (yy < board.length - 1) {
                x = xx;
                y = yy;
                for (int i = yy + 1; i < board.length; i++) {
                    if (board[i].charAt(x) == 'D') {
                        y = i - 1;
                        break;
                    } else if (i == board.length - 1) {
                        y = i;
                    }
                }
                if (board[y].charAt(x) == 'G')
                    return s + 1;
                if (visited[x][y] == false) {
                    visited[x][y] = true;
                    X.addLast(x);
                    Y.addLast(y);
                    steps.addLast(s + 1);
                }
            }

            // 왼쪽으로 이동
            if (xx > 0) {
                x = xx;
                y = yy;
                for (int i = xx - 1; i >= 0; i--) {
                    if (board[y].charAt(i) == 'D') {
                        x = i + 1;
                        break;
                    } else if (i == 0) {
                        x = i;
                    }
                }
                if (board[y].charAt(x) == 'G')
                    return s + 1;
                if (visited[x][y] == false) {
                    visited[x][y] = true;
                    X.addLast(x);
                    Y.addLast(y);
                    steps.addLast(s + 1);
                }
            }

            // 오른쪽으로 이동
            if (xx < board[0].length() - 1) {
                x = xx;
                y = yy;
                for (int i = xx + 1; i < board[0].length(); i++) {
                    if (board[y].charAt(i) == 'D') {
                        x = i - 1;
                        break;
                    } else if (i == board[0].length() - 1) {
                        x = i;
                    }
                }
                if (board[y].charAt(x) == 'G')
                    return s + 1;
                if (visited[x][y] == false) {
                    visited[x][y] = true;
                    X.addLast(x);
                    Y.addLast(y);
                    steps.addLast(s + 1);
                }
            }

        }

        return -1;

    }
}

public class _20240721_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int result1 = s.solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        int result2 = s.solution(new String[] {".D.R", "....", ".G..", "...D"});

        System.out.println(result1 + " " + result2);

    }
}
