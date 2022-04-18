import kotlin.math.abs

/*
    Date    : 2022.04.15
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/67256
 */

import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val keypads = mapOf(1 to Pair(0,0), 2 to Pair(0,1), 3 to Pair(0,2),
                4 to Pair(1,0), 5 to Pair(1,1), 6 to Pair(1,2),
                7 to Pair(2,0), 8 to Pair(2,1), 9 to Pair(2,2),
                "*" to Pair(3,0), 0 to Pair(3,1), "#" to Pair(3,2))

        var leftPosition = keypads["*"]
        var rightPosition = keypads["#"]

        var answer = ""
        numbers.forEach { number ->
            when(number){
                1, 4, 7 -> {
                    answer += 'L'
                    leftPosition = keypads[number]
                }
                3, 6, 9 -> {
                    answer += 'R'
                    rightPosition = keypads[number]
                }
                else ->{
                    val currentHand = searchNumberHand(leftPosition!!, rightPosition!!, keypads[number]!!, hand == "right")
                    if (currentHand == 'R') {
                        rightPosition = keypads[number]
                    } else {
                        leftPosition = keypads[number]
                    }
                    answer += currentHand
                }

            }
        }
        return answer
    }

    fun searchNumberHand(left: Pair<Int,Int>, right: Pair<Int,Int>, target: Pair<Int,Int>, isRightHand: Boolean): Char {
        val leftMove = abs(left.first - target.first) + abs(left.second - target.second)
        val rightMove = abs(right.first - target.first) + abs(right.second - target.second)

        if (leftMove == rightMove) {
            return if (isRightHand) 'R' else 'L'
        }

        return if (leftMove > rightMove) 'R' else 'L'
    }
}}