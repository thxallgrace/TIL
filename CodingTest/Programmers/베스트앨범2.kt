/*
    Date    : 2022.07.25
    level   : 3
    url     : https://school.programmers.co.kr/learn/courses/30/lessons/42579
    explanation : https://diane-kim.tistory.com/12
 */

class Solution {
    fun solution(genres: Array<String>, plays: IntArray) : IntArray {
        return genres.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten()
            .toIntArray()
    }
}
