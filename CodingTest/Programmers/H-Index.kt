/*
    Date    : 2022.06.20
    level   : 2
    url     : https://programmers.co.kr/learn/courses/30/lessons/42747
 */

class Solution {
    fun solution(citations: IntArray): Int {
        citations.sort()

        if (citations[0] >= citations.size) {
            return citations.size
        }

        for (hIndex in citations.size - 1 downTo citations[0]) {
            val findPos = if (hIndex * 2 <= citations.size) hIndex else citations.size - hIndex
            if (citations[findPos] >= hIndex) {
                return hIndex
            }
        }
        return -1
    }
}
