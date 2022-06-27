/*
    Date    : 2022.07.04
    level   : 2
    url     : https://programmers.co.kr/learn/courses/30/lessons/42842
 */

class Solution {
    val edge = 4
    
    fun solution(brown: Int, yellow: Int): IntArray {
        var carpetWidth = 0
        for (width in (brown / 2) downTo 1) {
            if (yellow % width == 0 && getBrownCount(width, yellow) == brown) {
                carpetWidth = width
                break
            }
        }
        return intArrayOf(carpetWidth + 2, (yellow/carpetWidth) + 2)
    }

    private fun getBrownCount(width: Int, yellow: Int): Int {
        val height = yellow / width
        return width * 2 + height * 2 + edge
    }
}
