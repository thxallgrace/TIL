/*
    Date    : 2022.06.13
    level   : 2
    url     : https://programmers.co.kr/learn/courses/30/lessons/42888
 */

class Solution {
  fun solution(record: Array<String>): Array<String> {
    val nickname = mutableMapOf<String, String>()
     for (r in record) {
      val chatInfo = r.split(" ")
       
      if (chatInfo[0] != "Leave") {
        nickname[chatInfo[1]] = chatInfo[2]
      }
    }
    var answer = mutableListOf<String>()
    record.forEach {
      val chatInfo = it.split(" ")
      if (chatInfo[0] == "Enter"){
        answer.add("${nickname[chatInfo[1]]}님이 들어왔습니다.")
      }
      if (chatInfo[0] == "Leave") {
        answer.add("${nickname[chatInfo[1]]}님이 나갔습니다.")
      }
    }
     
    return answer.toTypedArray()
  }
}
