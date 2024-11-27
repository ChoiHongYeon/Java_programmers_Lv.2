// 프로세스 (https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java)
package _20241127_1;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Deque<Integer> processes = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int priorities_count[] = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            processes.addLast(i);
            queue.addLast(priorities[i]);
            priorities_count[priorities[i]]++;
        }

        int answer = 0;
        while (true) {
            int process = processes.removeFirst();
            int priority = queue.removeFirst();
            boolean running = true;
            for (int i = priority + 1; i < 10; i++) {
                if (priorities_count[i] > 0) {
                    running = false;
                    break;
                }
            }
            if (running) {
                answer++;
                priorities_count[priority]--;
                if (process == location)
                    break;
            } else {
                processes.addLast(process);
                queue.addLast(priority);
            }
        }

        return answer;

    }
}

public class _20241127_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(new int[] {2, 1, 3, 2}, 2));
        System.out.println(s.solution(new int[] {1, 1, 9, 1, 1, 1}, 0));

    }
}