// 행렬의 곱셈 (https://school.programmers.co.kr/learn/courses/30/lessons/12949?language=java)
package _20241104_1;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;

    }
}

public class _20241104_1 {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] arr1_1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2_1 = {{3, 3}, {3, 3}};

        int[][] arr1_2 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2_2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] return1 = s.solution(arr1_1, arr2_1);
        int[][] return2 = s.solution(arr1_2, arr2_2);

        for (int i = 0; i < return1.length; i++) {
            for (int j = 0; j < return1[0].length; j++) {
                System.out.print(return1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < return2.length; i++) {
            for (int j = 0; j < return2[0].length; j++) {
                System.out.print(return2[i][j] + " ");
            }
            System.out.println();
        }

    }
}