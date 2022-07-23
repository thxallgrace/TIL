/*
    Date    : 2022.07.25
    level   : 3
    url     : https://school.programmers.co.kr/learn/courses/30/lessons/42579
    explanation : https://diane-kim.tistory.com/12
 */

class Solution {
    fun solution(genres: Array<String>, plays: IntArray) : IntArray {
        val songList = genres.toList().zip(plays.toList())
        val genreRanking = getGenreRanking(genres, songList)

        val sortedSongList = songList.sortedByDescending { it.second }
        val answer = arrayListOf<Int>()
        for(genre in genreRanking) {
            val top2Song = mutableMapOf<Int, Int>()
            songList.forEachIndexed { index, song ->
                if(song.first == genre){
                    top2Song[index] = song.second
                }
            }
            answer.addAll(top2Song.toList().sortedByDescending { it.second }.map { it.first }.take(2))
        }
        return answer.toIntArray()
    }

    private fun getGenreRanking(genres: Array<String>, songList: List<Pair<String,Int>>) : List<String>{
        val ranking = mutableMapOf<String, Int>()
        genres.toSet().forEach { genre ->
            ranking[genre] = songList.sumBy { if(it.first == genre) it.second else 0 }
        }
        return ranking.toList().sortedByDescending { it.second }.map { it.first }
    }
}
