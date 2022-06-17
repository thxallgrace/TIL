/*
    Date    : 2022.05.30
    level   : 2
    url     : https://programmers.co.kr/learn/courses/30/lessons/42578
 */

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var clothHashMap = mutableMapOf<String, Int>()
        var answer = 1
        clothes.forEach {
            if(clothHashMap.containsKey(it[1])){
                clothHashMap[it[1]] = clothHashMap[it[1]]!!.plus(1)
            }else{
                clothHashMap[it[1]] = 1
            }
        }
        for(clothCount in clothHashMap.values){
            answer = answer.times(clothCount+1)
        }
        return answer -1
    }
}
