/*
    Date    : 2022.05.02
    level   : 1
    url     : https://programmers.co.kr/learn/courses/30/lessons/42862
 */

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val extraClothes = getExtraClothes(lost, reserve)
        val lostNumberArr = lost.clone().sorted().toMutableList()
        var doNotHaveClothesPerson = 0
        
        for (lostNumber in lostNumberArr) {
            if (reserve.contains(lostNumber)) {
                continue
            }
            val rentPersonNumber = getRentPersonNumber(lostNumber, extraClothes)
            if (rentPersonNumber != 0) {
                extraClothes.remove(rentPersonNumber)
            } else {
                doNotHaveClothesPerson++
            } 
        }
        
        return (n - doNotHaveClothesPerson)
    }

    private fun getExtraClothes(lostNumberArr: IntArray, reserve: IntArray): MutableList<Int> {
        return reserve.filterNot { lostNumberArr.contains(it) }.sorted().toMutableList()
    }

    private fun getRentPersonNumber(lostNumber: Int, remainExtraClothes: List<Int>): Int {
        if (remainExtraClothes.contains(lostNumber - 1)) {
            return lostNumber - 1
        } else if (remainExtraClothes.contains(lostNumber + 1)) {
            return lostNumber + 1
        } else {
            return 0
        }
    }
}
