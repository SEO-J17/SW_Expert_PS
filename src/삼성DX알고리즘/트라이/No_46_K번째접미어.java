package 삼성DX알고리즘.트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No_46_K번째접미어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			ArrayList<String> list = new ArrayList<>();
			int idx = Integer.parseInt(br.readLine());
			String str = br.readLine();
			list.add(str);
			for (int i = 1; i < str.length(); i++) {
				list.add(str.substring(i, str.length()));
			}
			Collections.sort(list);

			if (idx - 1 > list.size() - 1) {
				sb.append("none").append("\n");
			} else {
				sb.append(list.get(idx - 1)).append("\n");
			}

		}
		System.out.println(sb);
	}
}
