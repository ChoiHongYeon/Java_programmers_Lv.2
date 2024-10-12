// 짝지어 제거하기 (https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=java)
package _20241012_1;
import java.util.*;

class Solution
{
    public int solution(String s)
    {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }

        int n = 0;
        while (n < list.size()) {
            if (n + 1 < list.size() && list.get(n).equals(list.get(n + 1))) {
                list.remove(n);
                list.remove(n);
                if (n > 0)
                    n--;
            } else
                n++;
        }

        return list.isEmpty() ? 1 : 0;

    }
}

public class _20241012_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution("baabaa"));
        System.out.println(s.solution("cdcd"));

    }
}
