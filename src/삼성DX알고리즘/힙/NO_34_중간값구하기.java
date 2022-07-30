package 伙己DX舅绊府硫.赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NO_34_吝埃蔼备窍扁 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> min_qu = new PriorityQueue<>(); // 弥家赛
			PriorityQueue<Integer> max_qu = new PriorityQueue<>(Collections.reverseOrder()); // 弥措 赛
			min_qu.add(first);

			int mid = first;
			int result = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num >= mid) {
						min_qu.add(num);
					} else if (num < mid) {
						max_qu.add(num);
					}
				}
				if (min_qu.size() > max_qu.size()) {
					mid = min_qu.peek();
				} else if (min_qu.size() < max_qu.size()) {
					mid = max_qu.peek();
				}
				
				result += (mid % 20171109);
			}

			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}
}
