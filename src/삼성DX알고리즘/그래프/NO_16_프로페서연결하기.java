package �ＺDX�˰���.�׷���;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NO_16_�����伭�����ϱ� {
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int map[][];
	static int n, max_node;
	static int min_distance;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			ArrayList<Point> list = new ArrayList<>(); // �ھ �ִ� ��ǥ���� �����ϴ� ����Ʈ
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			max_node = -1;
			min_distance = 99999;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) { // ���̾ƴ� �ھ �����ؾ��Ѵ�
						if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
							continue;
						}
						list.add(new Point(i, j)); // �ھ �ִ� ��ǥ�� �����ϴ� ����Ʈ
					}
				}
			}

			dfs(0, 0, 0, list);
			sb.append(min_distance).append("\n");
		}

		System.out.println(sb);

	}

	private static void dfs(int idx, int node_cnt, int distance, ArrayList<Point> list) {
		if (idx == list.size()) {
			if (max_node < node_cnt) {
				max_node = node_cnt;
				min_distance = distance;
			} else if (max_node == node_cnt) {
				if (min_distance > distance) {
					min_distance = distance;
				}
			}
			return;
		}

		int x = list.get(idx).x;
		int y = list.get(idx).y;

		for (int i = 0; i < 4; i++) {
			int cx = x;
			int cy = y;
			int xx = x;
			int yy = y;
			int cnt = 0;

			while (true) {		//������ ��ġ�Ѵ�.������ ������������ �ۿ� ���ư��� �����Ƿ�!
				xx += dx[i];
				yy += dy[i];
				if (xx < 0 || yy < 0 || xx >= n || yy >= n) {
					break;
				}
				if (map[xx][yy] == 1) { // �����̳� �������� ���� ���� �����ٸ� ������ ��ġ���ϹǷ� break.cnt=0���� �ʱ�ȭ.
					cnt = 0;
					break;
				}
				cnt++;
			}

			for (int j = 0; j < cnt; j++) {
				cx += dx[i];
				cy += dy[i];
				map[cx][cy] = 1; // ī��Ʈ��ŭ ������ ���
			}

			if (cnt == 0) {
				dfs(idx + 1, node_cnt, distance, list);
			} else {
				dfs(idx + 1, node_cnt + 1, distance + cnt, list);
				cx = x;
				cy = y;
				for (int j = 0; j < cnt; j++) {		//�������·� ����
					cx += dx[i];
					cy += dy[i];
					map[cx][cy] = 0;
				}
			}
		}
	}

}
