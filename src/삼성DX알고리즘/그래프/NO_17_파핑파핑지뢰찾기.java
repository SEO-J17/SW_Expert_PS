package 삼성DX알고리즘.그래프;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class NO_17_파핑파핑지뢰찾기 {
	static int n;
	static char map[][];
	static int dx[] = { 0, 0, -1, 1, -1, -1, 1, 1 }; // 상하좌우대각선
	static int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];

			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = temp.charAt(j);
				}
			}

			findBomb();		//맵을 지뢰가 있는칸, 없는칸을 표시한다.
			
			//0이면 연쇄반응을 일으키고 아니면 그냥 방문 처리를 하여 계산한다
			int click = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '0') {
						click++;
						bfs(i, j);
					}
				}
			}
			
			//안눌린칸이 있다면 눌러준다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '1') {
						click++;
					}
				}
			}

			sb.append(click).append("\n");

		}

		System.out.println(sb);

	}

	private static void bfs(int x, int y) {
		Queue<Point> qu = new LinkedList();
		qu.add(new Point(x, y));
		map[x][y] = '3';
		while (!qu.isEmpty()) {
			Point point = qu.poll();
			for (int i = 0; i < 8; i++) {
				int xx = point.x + dx[i];
				int yy = point.y + dy[i];
				if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
					if (map[xx][yy] == '0') {
						qu.add(new Point(xx, yy));
					}
					map[xx][yy] = '3'; // 방문
				}
			}
		}
	}

	private static void findBomb() {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				boolean flag = false;
				if (map[x][y] == '.') {
					for (int i = 0; i < 8; i++) {
						int xx = x + dx[i];
						int yy = y + dy[i];
						if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
							if (map[xx][yy] == '*') {
								flag = true;
								map[x][y] = '1';
								break;
							}
						}
					}
					if (!flag) {
						map[x][y] = '0';
					}
				}
			}
		}
	}
}
