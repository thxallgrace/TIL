/*
    Date    : 2022.07.11
    level   : 2
    url     : https://school.programmers.co.kr/learn/courses/30/lessons/12914
*/
 
import java.math.BigInteger

class Solution {
    fun solution(n: Int): Long {
        var answer = 1.toBigInteger()

        for (i in 1L..n / 2L) {
            val j: Long = n - i * 2
            if (i == 1L) {
                answer += (i + j).toBigInteger()
                continue
            }

            if (j == 0L) {
                answer += 1L.toBigInteger()
                break
            }

            answer += combi(i + j, if (i > j) j else i)
        }
        return (answer.remainder(1234567L.toBigInteger())).toLong()
    }


    fun combi(total: Long, r: Long): BigInteger {
        var top = total.toBigInteger()
        var bottom = r.toBigInteger()
        for (i in 1 until r) {
            top = top.multiply((total - i).toBigInteger())
            bottom = bottom.multiply((r - i).toBigInteger())
        }
        return (top / bottom)
    }
}
