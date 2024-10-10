// 숫자의 표현 (https://school.programmers.co.kr/learn/courses/30/lessons/12924?language=java)
package _20241010_1;

class Solution {
    public int solution(int n) {

        int answer = 0;
        int s = 0;

        for (int i = 0; i < n; i++) {
            if (s > n)
                break;
            s += i;
            if (n - s != 0 && (n - s) % (i + 1) == 0)
                answer++;
        }

        return answer;

    }
}

public class _20241010_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(15));

    }
}