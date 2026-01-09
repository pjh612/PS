package java.P5427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static class Point {
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static Queue<Point> q = new LinkedList<>();
  static int[][] visit = new int[1001][1001];
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    char[][] map = new char[1001][1001];
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int c = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int answer = -1;
      int sx = 0, sy = 0;
      for (int j = 0; j < r; j++) {
        map[j] = br.readLine().toCharArray();
        for (int k = 0; k < c; k++) {
          visit[j][k] = -1;
          if (map[j][k] == '*') {
            visit[j][k] = 0;
            q.add(new Point(k, j));
          } else if (map[j][k] == '@') {
            visit[j][k] = 0;
            sy = j;
            sx = k;
          }
        }
      }
      q.add(new Point(sx, sy));
      while (!q.isEmpty()) {
        Point cur = q.poll();
        if (map[cur.y][cur.x] != '*' && (cur.x == 0 || cur.x == c - 1 || cur.y == 0 || cur.y == r - 1)) {
          answer = visit[cur.y][cur.x] + 1;
          break;
        }
        for (int dir = 0; dir < 4; dir++) {
          int nx = cur.x + dx[dir];
          int ny = cur.y + dy[dir];

          if (ny >= 0 && nx >= 0 && nx < c && ny < r && visit[ny][nx] == -1 && map[ny][nx] != '#') {
            if ((map[cur.y][cur.x] != '*' && map[ny][nx] == '*') ||  map[ny][nx] == '*') {
              continue;
            }
            if (map[cur.y][cur.x] == '*') {
              map[ny][nx] = '*';
            } else {
              map[ny][nx] = '@';
            }
            q.add(new Point(nx, ny));
            visit[ny][nx] = visit[cur.y][cur.x] + 1;

          }
        }
      }
      if (answer == -1) {
        System.out.println("IMPOSSIBLE");
      } else {
        System.out.println(answer);
      }
      q.clear();
    }
  }

}
