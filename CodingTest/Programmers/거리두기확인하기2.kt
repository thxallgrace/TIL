/*
    Date    : 2022.04.25
    level   : 2
    url     : https://programmers.co.kr/learn/courses/30/lessons/81302
 */

public class Solution {

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(5)
        for (i in places.indices) {
            answer[i] = search(places[i]) // place ??? ??
        }
        return answer
    }

    // P?? ??? P? ??, O? ? ??? P? 2?? ??
    fun search(place: Array<String>): Int {
        val detail = convertCharArray(place)

        for (i in detail.indices) {
            for (j in detail[i].indices) {

                var sum = if (detail[i][j] == 'P') 1 else 0
                if (detail[i][j] == 'X') continue

                if (i > 0) {
                    sum += if (detail[i - 1][j] == 'P') 1 else 0
                }

                if (i < detail.size - 1) {
                    sum += if (detail[i + 1][j] == 'P') 1 else 0
                }

                if (j > 0) {
                    sum += if (detail[i][j - 1] == 'P') 1 else 0
                }

                if (j < detail[i].size - 1) {
                    sum += if (detail[i][j + 1] == 'P') 1 else 0
                }

                if (sum >= 2) {
                    return 0
                }
            }
        }
        return 1
    }

    private fun convertCharArray(stringList: Array<String>): List<CharArray> {
        val group = arrayListOf<CharArray>()
        stringList.forEach { group.add(it.toCharArray()) }
        return group
    }
}
