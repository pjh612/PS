package P_92343_양과_늑대;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 각 정점에 이어진 자식을 저장할 수 있는 tree 리스트 생성
 * 방문 후보지를 담을 candidates를 활용 방문한 정점은 nextCandidates에서 제거, 그 다음 방문지 추가
 * 양이 늑대보다 적지 않을 때만 다음 탐색
 */

class Solution {
    private List<Integer>[] tree;
    private int answer = 0;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree[parent].add(child);
        }

        Set<Integer> candidates = new HashSet<>(tree[0]);
        dfs(1, 0, candidates, info);

        return answer;
    }

    private void dfs(int sheep, int wolf, Set<Integer> candidates, int[] info) {
        answer = Math.max(answer, sheep);

        for (int next : candidates) {
            int nextSheep = sheep + (info[next] == 0 ? 1 : 0);
            int nextWolf = wolf + (info[next] == 1 ? 1 : 0);

            if (nextWolf >= nextSheep) {
                continue;
            }

            Set<Integer> nextCandidates = new HashSet<>(candidates);
            nextCandidates.remove(next);
            nextCandidates.addAll(tree[next]);

            dfs(nextSheep, nextWolf, nextCandidates, info);
        }
    }
}