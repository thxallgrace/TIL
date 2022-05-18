/*
    Date    : 2022.05.16
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/81301
 */

class Solution {
    fun solution(s: String): Int {
        val numberStringArr = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var answer = s
        numberStringArr.forEachIndexed { index, number ->
            answer = answer.replace(number, index.toString())
            if (isNumeric(answer)) {
                return@forEachIndexed
            }
        }
        return answer.toInt()
    }
    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }
}
