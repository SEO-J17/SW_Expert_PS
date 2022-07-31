package 삼성DX알고리즘.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class No_6_암호문3 {
	static List<Integer> list;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= 10; l++) {
			sb.append("#" + l + " ");
			int n = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int cmd_num = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmd_num; i++) {
				String cmd = st.nextToken();
				if (cmd.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					insert(idx, num);
				} else if (cmd.equals("A")) {
					int num = Integer.parseInt(st.nextToken());
					add(num);
				} else if (cmd.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					remove(idx, num);
				}
			}

			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static void remove(int idx, int num) {
		for (int i = 0; i < num; i++) {
			list.remove(idx);
		}
	}

	private static void add(int num) {
		for (int i = 0; i < num; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
	}

	private static void insert(int idx, int num) {
		for (int i = 0; i < num; i++) {
			list.add(idx + i, Integer.parseInt(st.nextToken()));
		}

	}

}
