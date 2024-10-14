// 점프와 순간 이동 (https://school.programmers.co.kr/learn/courses/30/lessons/12980?language=java)
package _20241014_1;
import java.util.*;

class Solution {
    public int solution(int n) {

        int answer = 0;
        Deque<Integer> location = new ArrayDeque<>();
        Deque<Integer> jump = new ArrayDeque<>();

        location.add(n);
        jump.add(0);

        while (!location.isEmpty()) {

            int L = location.removeFirst();
            int J = jump.removeFirst();

            if (L == 0) {
                answer = J;
                break;
            } else {
                if (L % 2 == 0) {
                    location.addLast(L / 2);
                    jump.addLast(J);
                }
                location.addLast(L - 1);
                jump.addLast(J + 1);
            }

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