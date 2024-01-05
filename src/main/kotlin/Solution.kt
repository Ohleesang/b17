//n : 지점의 개수, s: 출발지점, a : A의 도착지점, b : B의 도착지점 , fares :지점 사이의 예상 택시요금
//각각의 도착 지점까지 택시를 타고 갈때 최저 예상 택시요금을 계산하여 return
//만약 따로타고 각자 이동하는 경우의 택시요금이 더 낮다면 합승하지않아도된다.

/**
 * 1. 노드를 구현 하는 자료구조 정의
 *  - 양방향성을 고려해야함
 *  - 노드와 간선 그리고 가중치가 있음
 * 2. 최단거리를 구하는 알고리즘 필요
 *  - 탐색기법을 이용
 *  - a지점과 b 지점 둘다 지나야하므로
 *
 *  1. node 의 좌표값(x)을 매핑
 *  2. 해당되는 값중 가장 작은경우를 선택
 *     - 해당되는 값이 없을 경우를 생각 >> 이전상태로 되돌아간다?? 그리고 마지막 일경우 그걸 선택하여 그대로 y값으로 처리한다?
 *     - 해당되는 값이 있다면 y값을 확인
 *  3. 이후 node의 좌표값(y) 를 확인
 *      - 좌표값이 a,b 값이 있다면 check하고 가중치를 합쳐서 그값을 return 하고 그값으로 다시 1번
 *      - a,b 값이 없는 경우를 생각
 *      - a,b 값이 둘다 check 되었다면 합산한 가중치를 계산하여 return
 */

data class Node(val x: Int, val y: Int)
class Solution {
    private var sortedMap : Map<Node,Int> = mapOf()
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = 0

        //a. 자료형태 정의 (node,weight)
        val tempMap = fares.associate { (u, v, w) ->
            Pair(Node(u, v), w)
        }.toMutableMap()
        val revMap = fares.associate { (u, v, w) ->
            Pair(Node(v, u), w)
        }
        val map = tempMap + revMap
        sortedMap = map.toList().sortedBy { it.first.x }.toMap()

        return answer
    }
    fun searchTaxiFee(){

    }
}

fun main() {
    val a = Solution()
    a.solution(
        6, 4, 6, 2, arrayOf(
            intArrayOf(4, 1, 10),
            intArrayOf(3, 5, 24),
            intArrayOf(5, 6, 2),
            intArrayOf(3, 1, 41),
            intArrayOf(5, 1, 24),
            intArrayOf(4, 6, 50),
            intArrayOf(2, 4, 66),
            intArrayOf(2, 3, 22),
            intArrayOf(1, 6, 25),
        )
    )//82
    a.solution(
        7, 3, 4, 1, arrayOf(
            intArrayOf(5, 7, 9),
            intArrayOf(4, 6, 4),
            intArrayOf(3, 6, 1),
            intArrayOf(3, 2, 3),
            intArrayOf(2, 1, 6),
        )
    )//14
    a.solution(
        6, 4, 5, 6, arrayOf(
            intArrayOf(2, 6, 8),
            intArrayOf(6, 3, 7),
            intArrayOf(4, 6, 7),
            intArrayOf(6, 5, 11),
            intArrayOf(2, 5, 12),
            intArrayOf(5, 3, 20),
            intArrayOf(2, 4, 8),
            intArrayOf(4, 3, 9),
        )
    )

}