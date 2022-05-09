/*
    Date    : 2022.05.16
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/12910
 */

class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()
        arr.forEach {
            if(it % divisor == 0){
                answer += it
            }
        }
        answer.sort()
        return if(answer.isEmpty()) intArrayOf(-1) else answer
    }
}
