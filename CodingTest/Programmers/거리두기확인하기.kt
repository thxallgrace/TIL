/*
    Date    : 2022.04.25
    level   : 2
    url     : https://programmers.co.kr/learn/courses/30/lessons/81302
 */

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        val answer = arrayListOf<Int>()
        places.forEach {
            val placeCharArr = convertCharArray(it)
            answer.add(search(placeCharArr))
        }
        return answer.toIntArray()
    }

    private fun convertCharArray(stringList: Array<String>): List<CharArray> {
        val group = arrayListOf<CharArray>()
        stringList.forEach { group.add(it.toCharArray()) }
        return group
    }

    private fun search(group: List<CharArray>): Int {
        val top = arrayOf(-1, 0)
        val bottom = arrayOf(1, 0)
        val right = arrayOf(0, 1)
        val left = arrayOf(0, -1)

        for (row: Int in group.indices) {
            for (column: Int in group[0].indices) {
                if (group[row][column] == 'P') {

                    val topCondition = row - 1 >= 0
                    val bottomCondition = row + 1 < group.size
                    val leftCondition = column - 1 >= 0
                    val rightCondition = column + 1 < group.size

                    // 1 step
                    if (topCondition && group[row + top[0]][column + top[1]] == 'P') {
                        return 0
                    }
                    if (bottomCondition && group[row + bottom[0]][column + bottom[1]] == 'P') {
                        return 0
                    }
                    if (leftCondition && group[row + left[0]][column + left[1]] == 'P') {
                        return 0
                    }
                    if (rightCondition && group[row + right[0]][column + right[1]] == 'P') {
                        return 0
                    }

                    // 2 step
                    if (row - 2 >= 0 && group[row + top[0] * 2][column + top[1] * 2] == 'P' && group[row + top[0]][column + top[1]] != 'X') {
                        return 0
                    }
                    if (row + 2 < group.size && group[row + bottom[0] * 2][column + bottom[1] * 2] == 'P' && group[row + bottom[0]][column + bottom[1]] != 'X') {
                        return 0
                    }
                    if (column - 2 >= 0 && group[row + left[0] * 2][column + left[1] * 2] == 'P' && group[row + left[0]][column + left[1]] != 'X') {
                        return 0
                    }
                    if (column + 2 < group.size && group[row + right[0] * 2][column + right[1] * 2] == 'P' && group[row + right[0]][column + right[1]] != 'X') {
                        return 0
                    }

                    // Top Left
                    if (topCondition && leftCondition && group[row + top[0]][column + left[1]] == 'P') {
                        if (group[row + top[0]][column + top[1]] != 'X' || group[row + left[0]][column + left[1]] != 'X') {
                            return 0
                        }
                    }

                    // Top Right
                    if (topCondition && rightCondition && group[row + top[0]][column + right[1]] == 'P') {
                        if (group[row + top[0]][column + top[1]] != 'X' || group[row + right[0]][column + right[1]] != 'X') {
                            return 0
                        }
                    }

                    // Bottom Left
                    if (bottomCondition && leftCondition && group[row + bottom[0]][column + left[1]] == 'P') {
                        if (group[row + bottom[0]][column + bottom[1]] != 'X' || group[row + left[0]][column + left[1]] != 'X') {
                            return 0
                        }
                    }

                    // Bottom Right
                    if (bottomCondition && rightCondition && group[row + bottom[0]][column + right[1]] == 'P') {
                        if (group[row + bottom[0]][column + bottom[1]] != 'X' || group[row + right[0]][column + right[1]] != 'X') {
                            return 0
                        }
                    }
                }
            }
        }
        return 1
    }
}
