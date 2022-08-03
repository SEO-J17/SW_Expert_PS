package 삼성DX알고리즘.트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class NO_47_K번째문자열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			int idx = Integer.parseInt(br.readLine());
			String str = br.readLine();

			TreeSet<String> set = new TreeSet<>();
			for (int i = 0; i < str.length(); i++) {
				for (int j = i + 1; j <= str.length(); j++) {
					String temp = str.substring(i, j);
					set.add(temp);
				}
			}
			if (set.size() - 1 < idx - 1) {
				sb.append("none").append("\n");
			} else {
				Iterator<String> it = set.iterator();
				int cnt = 0;
				String result = "";
				while (cnt < idx) {
					result = it.next();
					cnt++;
				}
				sb.append(result).append("\n");
			}
		}
		System.out.println(sb);
	}

}
