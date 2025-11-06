package dfs;

import org.junit.jupiter.api.Test;

public class OrganicCabbageTest {

    /**
     * 유기농 배추 (섬의 개수)
     * <p>
     * DFS의 가장 기본이 되는 '연결 요소(Component) 찾기' 문제입니다.
     * 문제 설명 어떤 밭에 배추가 심어져 있습니다. 배추들은 서로 인접(상, 하, 좌, 우)해 있으면 "연결되었다"고 봅니다.
     * 이 연결된 배추 덩어리(그룹)들을 보호하기 위해 배추흰지렁이가 필요합니다. 한 덩어리에는 한 마리의 지렁이만 있으면 됩니다.
     * 1은 배추가 심어진 땅, 0은 빈 땅을 의미하는 2D 맵이 주어질 때, 필요한 최소 배추흰지렁이의 수(즉, 총 배추 덩어리의 수)를 구하세요.
     * <p>
     * 예시 입력 (맵)
     * int[][] map = {
     * {1, 1, 0, 0, 0},
     * {1, 1, 0, 0, 0},
     * {0, 0, 1, 0, 0},
     * {0, 0, 0, 1, 1}
     * };
     * <p>
     * 예시 출력
     * 3
     * <p>
     * (0,0), (0,1), (1,0), (1,1)이 한 덩어리
     * (2,2)가 한 덩어리
     * (3,3), (3,4)가 한 덩어리
     * 총 3개의 덩어리가 있으므로, 지렁이는 3마리가 필요합니다.
     * <p>
     * 문제 출처 : Google Gemini
     */

    int[] dx = {-1, 1, 0, 0}; // 상, 하
    int[] dy = {0, 0, -1, 1}; // 좌, 우

    @Test
    void code() {
        int[][] map = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        boolean[][] visited = new boolean[map.length][map[0].length];

        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count++;
                    dfs(i, j, map, visited);
                }
            }
        }

        System.out.println("지렁이 수 : " + count);
    }

    private void dfs(int x, int y, int[][] map, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) { // 상, 하, 좌, 우 탐색
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[x].length) {
                continue;
            }

            if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                dfs(nextX, nextY, map, visited);
            }
        }
    }

}
