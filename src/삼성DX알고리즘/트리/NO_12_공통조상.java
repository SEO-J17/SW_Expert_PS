package 삼성DX알고리즘.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NO_12_공통조상 {
	static ArrayList<Integer>[] arr;
	static int n, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()); // 간선의 수
			int node1 = Integer.parseInt(st.nextToken()); // 찾아야되는 노드
			int node2 = Integer.parseInt(st.nextToken()); // 찾아야되는 노드
			arr = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}

			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			calc(node1, list1);
			calc(node2, list2);

			cnt = 0;
			int share_node = 0;
			for (int d : list1) {
				if (list2.contains(d)) {
					share_node = d;
					break;
				}
			}
			CalcNum(share_node);
			sb.append(share_node + " " + cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void CalcNum(int node) {
		cnt++;
		for (int i = 0; i < arr[node].size(); i++) {
			CalcNum(arr[node].get(i));
		}
	}

	private static void calc(int node, ArrayList<Integer> list) {
		if (node == 1) {
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (arr[i].contains(node)) {
				list.add(i);
				calc(i, list);
				return;
			}
		}
	}
}
