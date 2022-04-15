import kotlin.math.abs

/*
    Date    : 2022.04.15
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/67256
 */

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val keypads = mapOf("1" to "00", "2" to "01", "3" to "02",
                            "4" to "10", "5" to "11", "6" to "12",
                            "7" to "20", "8" to "21", "9" to "22",
                            "*" to "30", "0" to "31", "#" to "32")

        val leftKeypads = listOf("1", "4", "7", "*")
        val rightKeypads = listOf("3", "6", "9", "#")

        var leftPosition = "*"
        var rightPosition = "#"

        var answer = ""
        numbers.forEach { number ->
            if (leftKeypads.contains(number.toString())) {
                answer += "L"
                leftPosition = number.toString()
            } else if (rightKeypads.contains(number.toString())) {
                answer += "R"
                rightPosition = number.toString()
            } else {
                val currentHand = searchNumberHand(keypads[leftPosition]!!, keypads[rightPosition]!!, keypads[number.toString()]!!, hand == "right")
                if (currentHand == 'R') {
                    rightPosition = number.toString()
                } else {
                    leftPosition = number.toString()
                }
                answer += currentHand
            }
        }
        return answer
    }

    fun searchNumberHand(left: String, right: String, target: String, isRightHand: Boolean): Char {
        val leftMove = abs(left[0] - target[0]) + abs(left[1] - target[1])
        val rightMove = abs(right[0] - target[0]) + abs(right[1] - target[1])

        if (leftMove == rightMove) {
            return if (isRightHand) 'R' else 'L'
        }

        return if (leftMove > rightMove) 'R' else 'L'
    }
}