package 삼성DX알고리즘.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_8_수열편집 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			List<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 수열 길이
			int m = Integer.parseInt(st.nextToken()); // 추가 횟수
			int target_idx = Integer.parseInt(st.nextToken()); // 출력할 인덱스 번호
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				if (cmd.equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					list.add(idx, num);
				} else if (cmd.equals("C")) {
					int num = Integer.parseInt(st.nextToken());
					list.add(idx, num);
					list.remove(idx + 1);
				} else { // 삭제일때
					list.remove(idx);
				}
			}
			
			if (target_idx > list.size() - 1) {
				sb.append(-1).append("\n");
			} else {
				sb.append(list.get(target_idx)).append("\n");
			}
		}

		System.out.println(sb);

	}
}
