/*
    Date    : 2022.08.23
    level   : 3
    url     : https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */

import java.util.List;
import java.util.Arrays;

class Solution {
   
  public static int solution(int m, int n, int[][] puddles) {
        int[][] step = new int[m][n];

        List<int[]> puddleList = Arrays.asList(puddles);
        for(int i=0;i<puddleList.size();i++){
            if(puddleList.get(i).length == 2) {
                step[puddleList.get(i)[0]-1][puddleList.get(i)[1]-1] = -1;
            }
        }

        for(int a=0;a<step.length;a++){
            for(int b=0;b<step[a].length;b++){
                if(step[a][b]==-1){
                    if(a == 0 && b+1 < n) {
                        step[a][b+1] = -1;
                    } else if(b == 0 && a+1< m) {
                        step[a+1][b] = -1;
                    } 
                    continue;
                }
                
                if(a==0 || b== 0){
                    step[a][b]=1;
                    continue;
                }

                int top = step[a][b-1] == -1 ? 0 : step[a][b-1];
                int left = step[a-1][b] == -1 ? 0 : step[a-1][b];
                step[a][b] = (top + left)% 1000000007;
            }
        }

        return step[m-1][n-1] % 1000000007;
    }
}
