// 짝지어 제거하기 (https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=java)
package _20241012_1;
import java.util.*;

class Solution
{
    public int solution(String s)
    {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(String.valueOf(s.charAt(i))))
                stack.pop();
            else
                stack.push(String.valueOf(s.charAt(i)));
        }

        return stack.isEmpty() ? 1 : 0;

    }
}

public class _20241012_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution("baabaa"));
        System.out.println(s.solution("cdcd"));

    }
}