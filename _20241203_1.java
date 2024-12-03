// 타겟 넘버 (https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java)
package _20241203_1;
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(numbers[0]);
        deque.addLast(numbers[0] * -1);
        for (int i = 1; i < numbers.length; i++) {
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                int tmp = deque.removeFirst();
                deque.addLast(tmp + numbers[i]);
                deque.addLast(tmp - numbers[i]);
            }
        }

        int answer = 0;
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (deque.getFirst() == target)
                answer++;
            deque.removeFirst();
        }

        return answer;

    }
}

public class _20241203_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1, 1, 1, 1, 1}, 3));
        System.out.println(s.solution(new int[] {4, 1, 2, 1}, 4));

    }
}