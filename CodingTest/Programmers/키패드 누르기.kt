import kotlin.math.abs

/*
    Date    : 2022.04.15
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/67256
 */

class Solution {
    fun solution(numbers: IntArray, hand: String): String {

        // We replace '*' to 10, '#' to 12, '0' to 11
        var leftPosition = 10
        var rightPosition = 12

        var answer = ""
        numbers.forEach { number ->
            var n = if (number == 0) 11 else number

            when (n) {
                1, 4, 7 -> {
                    answer += 'L'
                    leftPosition = n
                }
                3, 6, 9 -> {
                    answer += 'R'
                    rightPosition = n
                }
                else -> {
                    val leftMove = calcDistance(abs(n - leftPosition))
                    val rightMove = calcDistance(abs(n - rightPosition))
                    if (leftMove > rightMove) {
                        answer += 'R'
                        rightPosition = n
                    } else if (rightMove > leftMove) {
                        answer += 'L'
                        leftPosition = n
                    } else {
                        if (hand == "right") {
                            answer += 'R'
                            rightPosition = n
                        } else {
                            answer += 'L'
                            leftPosition = n
                        }
                    }
                }

            }
        }
        return answer
    }

    fun calcDistance(number: Int): Int {
        when (number) {
            1, 3 -> return 1
            2, 4, 6 -> return 2
            5, 7, 9 -> return 3
            8, 10 -> return 4
            else -> return 0
        }
    }
}