// 구명보트 (https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java)

package _20241029_1;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < people.length; i++) {
            deque.addLast(people[i]);
        }

        int answer = 0;
        while (!deque.isEmpty()) {

            int weight = deque.getLast();
            deque.removeLast();
            if (!deque.isEmpty() && weight + deque.getFirst() <= limit)
                deque.removeFirst();
            answer++;

        }

        return answer;

    }
}

public class _20241029_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int return1 = s.solution(new int[] {70, 50, 80, 50}, 100);
        int return2 = s.solution(new int[] {70, 80, 50}, 100);
        System.out.println(return1 + " " + return2);

    }
}