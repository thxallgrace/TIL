/*
    Date    : 2022.05.09
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/42889
 */

class Solution {
    // Example N : 5, stages : [2, 1, 2, 6, 2, 4, 3, 3]
    
    fun solution(N: Int, stages: IntArray): IntArray {
        var playingPeopleCount = stages.size
        val failPercentArr = hashMapOf<Int, Double>() // Stage, Fail Percent

        // 각 스테이지의 실패율을 저장
        // Save fail percent of each stage.
        // Example : failPercentArr value => [1/8, 3/7, 2/4, 1/2, 0]
        getStageFailPeopleCountArr(N, stages).forEachIndexed { index, failedPerson ->
            if (failedPerson == 0) {
                failPercentArr[index] = 0.0
            } else {
                failPercentArr[index] = failedPerson / playingPeopleCount.toDouble()
                playingPeopleCount -= failedPerson
            }
        }

        // 실패율 저장한 배열 내림차순 정렬 후 각 Stage 배열 리턴
        // Sort descending failPercentArr value -> [2/4, 1/2, 3/7, 1/8, 0], key -> [2, 3, 1, 0, 4]
        val sortedFailPercentArr = failPercentArr.toList().sortedByDescending { (stage, failPercent) -> failPercent }
        return sortedFailPercentArr.map { it.first + 1 }.toIntArray()
    }

    // 각 스테이지에서 실패한 사람들의 갯수를 담은 배열 가져오는 함수
    // Get array that count of person who failed each stage
    // Example : stageFailPeopleCountArr => [1, 3, 2, 1, 0]
    fun getStageFailPeopleCountArr(N: Int, stages: IntArray): IntArray {
        val stageFailPeopleCountArr = IntArray(N)
        stages.forEach {
            if (it > N || it == 0) {
                return@forEach
            }
            stageFailPeopleCountArr[it - 1]++
        }
        return stageFailPeopleCountArr
    }
}
