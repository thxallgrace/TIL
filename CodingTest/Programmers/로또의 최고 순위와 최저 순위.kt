/*
    Date    : 2022.05.23
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/77484
 */

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val rankingByScore = mapOf(0 to 6, 1 to 6, 2 to 5, 3 to 4, 4 to 3, 5 to 2, 6 to 1)

        val duplicateCount = getDuplicateValueCount(lottos, win_nums)
        val zeroCount = lottos.count { it == 0 }
        val highestRanking = rankingByScore[duplicateCount + zeroCount]
        val lowestRanking = rankingByScore[duplicateCount]

        return intArrayOf(highestRanking!!, lowestRanking!!)
    }

    private fun getDuplicateValueCount(aArray: IntArray, bArray: IntArray): Int {
        var count = 0
        aArray.forEach { a ->
            bArray.forEach { b ->
                if (a == b) count++
            }
        }
        return count
    }
}
