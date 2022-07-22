package 삼성DX알고리즘.그래프;

public class NO_15_UserSolution {
	static int arr[][];
	static boolean visit[][];
	static int cnt, n;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	void bfs_init(int map_size, int map[][]) {
		arr = new int[map_size][map_size];
		n = map_size;
		visit = new boolean[map_size][map_size];
		for (int i = 0; i < map_size; i++) {
			for (int j = 0; j < map_size; j++) {
				if (map[i][j] == 1) {
					arr[i][j] = -1;
				} else {
					arr[i][j] = map[i][j];
				}

			}
		}

	}

	int bfs(int ax, int ay, int bx, int by) {
		cnt = 99999;
		calc(--ax, --ay, --bx, --by, 0);
		if (cnt == 99999) {
			return -1;
		} else {
			return cnt;
		}
	}

	private void calc(int x1, int y1, int x2, int y2, int depth) {
		if (x1 == x2 && y2 == y1) {
			if (cnt > depth) {
				cnt = depth;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int xx = dx[i] + y1;
			int yy = dy[i] + x1;
			if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
				if (!visit[xx][yy] && arr[xx][yy] == 0) {
					visit[xx][yy] = true;
					calc(yy, xx, x2, y2, depth + 1);
					visit[xx][yy] = false;
				}
			}
		}
	}
}
