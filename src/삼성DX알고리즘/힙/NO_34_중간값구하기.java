package 伙己DX舅绊府硫.赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			PriorityQueue<Integer> min_qu = new PriorityQueue<>(); // 弥家赛
			PriorityQueue<Integer> max_qu = new PriorityQueue<>(Collections.reverseOrder()); // 弥措 赛
			max_qu.add(Integer.parseInt(st.nextToken()));

			long result = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				min_qu.add(Integer.parseInt(st.nextToken()));
				max_qu.add(Integer.parseInt(st.nextToken()));

				if (max_qu.size() < min_qu.size()) {
					while (max_qu.size() < min_qu.size()) {
						max_qu.add(min_qu.poll());
					}
				}
				
				if (max_qu.peek() > min_qu.peek()) {
					int temp = min_qu.poll();
					min_qu.add(max_qu.poll());
					max_qu.add(temp);
				}
				result += max_qu.peek();
			}

			sb.append(result % 20171109).append("\n");

		}
		System.out.println(sb);
	}
}
