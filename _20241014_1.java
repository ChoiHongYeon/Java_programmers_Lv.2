// 점프와 순간 이동 (https://school.programmers.co.kr/learn/courses/30/lessons/12980?language=java)
package _20241014_1;
import java.util.*;

class Solution {
    public int solution(int n) {

        int answer = 0;

        while (n > 0) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n--;
                answer++;
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