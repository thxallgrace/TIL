/*
    Date    : 2022.10.02
    level   : 2
    url     : https://school.programmers.co.kr/learn/courses/30/lessons/92335
    blog    : https://diane-kim.tistory.com/14
 */

import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0

         n.toString(k).split("0").forEach {
            if(it.isNotBlank() && isPrime(it.toLong())){
                answer++
            }
        }
        return answer
    }

    fun isPrime(num: Long): Boolean {
        if(num<=1) return false 

        (2 ..sqrt(num.toDouble()).toLong()).forEach{
            if(num%it==0L) return false
        }
        return true
    }
}
