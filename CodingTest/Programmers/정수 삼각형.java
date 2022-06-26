/*
    Date    : 2022.06.27
    level   : 3
    url     : https://programmers.co.kr/learn/courses/30/lessons/43105
 */

import java.util.Arrays;

class Solution {
    
     public int solution(int[][] triangle) {
        int[][] dp = triangle;

        for (int i = 1; i < triangle.length; i++) {
            
            // 0번째 열 계산
            dp[i][0] = dp[i - 1][0] + dp[i][0];

            for (int j = 1; j < triangle[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
            }

            // 이 행의 마지막 열 계산
            int lastIndex = dp[i].length-1;
            dp[i][lastIndex] = dp[i - 1][lastIndex-1] + dp[i][lastIndex];
        }
         
        return Arrays.stream(dp[dp.length-1]).max().getAsInt();
    }
}
