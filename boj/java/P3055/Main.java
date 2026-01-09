package java.P3055;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static char[][] map;
  static Queue<Node> q;
  static Queue<Node> q2;
  static Queue<Node> posQ;
  static Queue<Node> posQ2;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int r, c;
  static boolean[][] visit;
  static boolean[][] visit2;
  static int moveCount;

  static boolean move() {
    while (!posQ.isEmpty()) {
      Node cur = posQ.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < c && ny < r && (map[ny][nx] == '.' || map[ny][nx] == 'D') && !visit2[ny][nx]) {
          if (map[ny][nx] == 'D') {
            return true;
          }
          moveCount++;
          visit2[ny][nx] = true;
          posQ2.add(new Node(nx, ny));
        }

      }
    }
    return false;
  }

  static void flood() {
    while (!q.isEmpty()) {
      Node cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < c && ny < r && (map[ny][nx] != 'X' && map[ny][nx] != 'D') && !visit[ny][nx]) {
          if (map[cur.y][cur.x] == '*') {
            q2.add(new Node(nx, ny));
            map[ny][nx] = '*';
            visit[ny][nx] = true;
          }
        }
      }
    }
  }

  static class Node {

    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    q = new LinkedList<>();
    q2 = new LinkedList<>();
    posQ = new LinkedList<>();
    posQ2 = new LinkedList<>();
    int sx = 0, sy = 0;
    map = new char[r][c];
    visit = new boolean[r][c];
    visit2 = new boolean[r][c];
    for (int i = 0; i < r; i++) {
      map[i] = br.readLine().toCharArray();
      for (int j = 0; j < c; j++) {
        if (map[i][j] == 'S') {
          posQ.add(new Node(j, i));
          visit2[i][j] = true;
        } else if (map[i][j] == '*') {
          q.add(new Node(j, i));
          visit[i][j] = true;
        }
      }
    }
    int answer = 0;
    while (true) {

      answer++;
      moveCount = 0;
      flood();
      if (move()) {
        System.out.println(answer);
        break;
      } else {
        while (!q2.isEmpty()) {
          q.add(q2.poll());
        }
        while (!posQ2.isEmpty()) {
          posQ.add(posQ2.poll());
        }
      }

      if (moveCount == 0) {
        System.out.println("KAKTUS");
        return;
      }
    }

  }


}
