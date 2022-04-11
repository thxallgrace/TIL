/*
    Date    : 2022.04.11
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/12922
 */

class Solution {
    fun solution(n: Int): String {
        var answer = ""
        for(i in 1..n) {
            answer += if(i%2==0) "박" else "수"
        }
        return answer
    }
}