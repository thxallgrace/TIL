/*
    Date    : 2022.04.11
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/12930
 */

class Solution {
    fun solution(word: String): String {
        var words = ArrayList<String>()
        word.split(" ").forEach{w -> words.add(convertWord(w))}

        return words.joinToString(" ")
    }

    fun convertWord(word: String): String {
        var result = ""
        word.forEachIndexed{index, char ->
            result += if(index%2==0) char.toUpperCase() else char.toLowerCase()
        }
        return result
    }
}
