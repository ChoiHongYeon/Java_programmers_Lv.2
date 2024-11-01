// 괄호 회전하기 (https://school.programmers.co.kr/learn/courses/30/lessons/76502?language=java)
package _20241101_1;
import java.util.*;

class Solution {
    public int solution(String s) {

        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            int t_f = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{')
                    deque.addLast(s.charAt(j));
                else {
                    if (deque.isEmpty()) {
                        t_f = 1;
                        break;
                    } else {
                        if (s.charAt(j) == ')' && deque.getLast() == '(')
                            deque.removeLast();
                        else if (s.charAt(j) == ']' && deque.getLast() == '[')
                            deque.removeLast();
                        else if (s.charAt(j) == '}' && deque.getLast() == '{')
                            deque.removeLast();
                        else {
                            t_f = 1;
                            break;
                        }
                    }
                }
            }
            if (t_f == 0 && deque.isEmpty())
                answer++;
            deque.clear();
            s = s.substring(1) + s.substring(0, 1);
        }

        return answer;

    }
}

public class _20241101_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution("[](){}"));
        System.out.println(s.solution("}]()[{"));
        System.out.println(s.solution("[)(]"));
        System.out.println(s.solution("}}}"));

    }
}