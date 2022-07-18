package 삼성DX알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class NO_1_새로운불면증풀이법 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#" + l + " ");
			HashSet<Integer> set = new HashSet();
			for (int i = 1;; i++) {
				String temp = String.valueOf(i * n);
				for (int k = 0; k < temp.length(); k++) {
					set.add(temp.charAt(k) - '0');
				}

				if (set.size() == 10) {
					sb.append(Integer.parseInt(temp)).append("\n");
					break;
				}
			}
		}

		System.out.println(sb);
	}
}
