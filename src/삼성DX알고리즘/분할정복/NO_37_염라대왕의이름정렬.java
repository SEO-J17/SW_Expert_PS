package 삼성DX알고리즘.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class NO_37_염라대왕의이름정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + "\n");
			int n = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				set.add(br.readLine());
			}
			ArrayList<String> list = new ArrayList<>(set);
			Collections.sort(list, new Comparator<String>() {
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					} else {
						return o1.length() - o2.length();
					}
				}
			});
			for (String s : list) {
				sb.append(s).append("\n");
			}
		}

		System.out.println(sb);
	}

}
