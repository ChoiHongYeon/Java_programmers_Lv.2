// 점프와 순간 이동 (https://school.programmers.co.kr/learn/courses/30/lessons/12980?language=java)
package _20241014_1;
import java.util.*;

class Solution {
    public int solution(int n) {

        int answer = 0;
        Deque<Integer> location = new ArrayDeque<>();
        Deque<Integer> remain_jump = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {

            location.add(1);
            remain_jump.add(i - 1);

            while (!location.isEmpty()) {

                int L = location.removeFirst();
                int R = remain_jump.removeFirst();

                if (R == 0) {
                    if (L == n) {
                        answer = i;
                        break;
                    } else if (L * 2 <= n) {
                        location.addLast(L * 2);
                        remain_jump.addLast(R);
                    }
                } else {
                    location.addLast(L + 1);
                    remain_jump.addLast(R - 1);
                    if (L * 2 < n) {
                        location.addLast(L * 2);
                        remain_jump.addLast(R);
                    }
                }

            }

            if (answer != 0)
                break;

        }

        return answer;

    }
}

public class _20241014_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(5) + " " + s.solution(6) + " " + s.solution(5000));

    }
}