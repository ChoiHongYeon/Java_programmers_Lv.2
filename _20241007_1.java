// 최솟값 만들기 (https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=java)
package _20241007_1;
import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;

    }
}

public class _20241007_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int answer1 = s.solution(new int[] {1, 4, 2}, new int[] {5, 4, 4});
        int answer2 = s.solution(new int[] {1, 2}, new int[] {3, 4});
        System.out.println(answer1 + " " + answer2);

    }
}