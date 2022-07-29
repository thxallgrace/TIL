/*
    Date    : 2022.08.01
    level   : 2
    url     : https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val progressPeriod = arrayListOf<Int>()

        for (i in progresses.indices) {
            progressPeriod.add(ceil((100 - progresses[i]).toDouble() / speeds[i]).toInt())
        }

        var workDay = 1
        var maxPeriod = progressPeriod[0]
        val answer = arrayListOf<Int>()
        (1 until progressPeriod.size).forEach { index ->
            if (maxPeriod >= progressPeriod[index]) {
                ++workDay
            } else {
                answer.add(workDay)
                maxPeriod = progressPeriod[index]
                workDay = 1
            }

            if (progressPeriod.lastIndex == index) {
                answer.add(workDay)
            }
        }
        return answer.toIntArray()
    }
}
