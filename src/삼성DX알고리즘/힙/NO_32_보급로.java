package »ï¼ºDX¾Ë°í¸®Áò.Èü;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NO_32_º¸±Þ·Î {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			int cost[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp.charAt(j) - '0';
				}
			}

			for (int i = 0; i < n; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}

			Queue<Point> qu = new LinkedList<>();
			boolean visit[][] = new boolean[n][n];

			qu.add(new Point(0, 0));
			cost[0][0] = 0;
			visit[0][0] = true;

			int result = Integer.MAX_VALUE;
			while (!qu.isEmpty()) {
				int dx[] = { 0, 0, -1, 1 };
				int dy[] = { 1, -1, 0, 0 };

				Point point = qu.poll();
				if (point.x == n - 1 && point.y == n - 1) {
					result = Math.min(cost[n - 1][n - 1], result);
				}
				for (int i = 0; i < 4; i++) {
					int xx = point.x + dx[i];
					int yy = point.y + dy[i];
					if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
						if (!visit[xx][yy] || cost[point.x][point.y] + arr[xx][yy] < cost[xx][yy]) {
							visit[xx][yy] = true;
							cost[xx][yy] = cost[point.x][point.y] + arr[xx][yy];
							qu.add(new Point(xx, yy));
						}
					}
				}
			}
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

}
