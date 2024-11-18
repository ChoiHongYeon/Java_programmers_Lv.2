// [1차] 캐시 (https://school.programmers.co.kr/learn/courses/30/lessons/17680?language=java)
package _20241118_1;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0)
            return cities.length * 5;

        String cache[] = new String[cacheSize];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = "";
        }
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {

            boolean inCache = false;
            for (int j = 0; j < cache.length; j++) {
                if (cities[i].toLowerCase().equals(cache[j].toLowerCase())) {
                    inCache = true;
                    break;
                }
            }

            if (inCache) {
                String newCache[] = new String[cacheSize - 1];
                int n = 0;
                for (int j = 0; j < cache.length; j++) {
                    if (!cities[i].toLowerCase().equals(cache[j].toLowerCase()))
                        newCache[n++] = cache[j];
                }
                for (int j = 0; j < newCache.length; j++) {
                    cache[j] = newCache[j];
                }
                cache[cache.length - 1] = cities[i];
                answer++;
            } else {
                for (int j = 1; j < cache.length; j++) {
                    cache[j - 1] = cache[j];
                }
                cache[cache.length - 1] = cities[i];
                answer += 5;
            }

        }

        return answer;

    }
}

public class _20241118_1 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int cacheSize1 = 3;
        int cacheSize2 = 3;
        int cacheSize3 = 2;
        int cacheSize4 = 5;
        int cacheSize5 = 2;
        int cacheSize6 = 0;
        String[] cities1 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities5 = new String[] {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities6 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(s.solution(cacheSize1, cities1));
        System.out.println(s.solution(cacheSize2, cities2));
        System.out.println(s.solution(cacheSize3, cities3));
        System.out.println(s.solution(cacheSize4, cities4));
        System.out.println(s.solution(cacheSize5, cities5));
        System.out.println(s.solution(cacheSize6, cities6));

    }
}
