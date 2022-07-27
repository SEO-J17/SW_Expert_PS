package 삼성DX알고리즘.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NO_26_단어가등장하는횟수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			String str = br.readLine();
			String target = br.readLine();
			int str_len = str.length();
			int target_len = target.length();
			int table[] = new int[target_len]; // 접미사이면서 접두사인 최대 문자열 길이를 저장하는 배열,부분 일치 테이블 이라고 한다.

			int idx = 0;
			for (int i = 1; i < target_len; i++) {
				// 일치하는 문자가 없고, 연속적으로 더 일치 하지 않으면 해당 테이블 인덱스 값을 idx에 저장해서 그 지점부터 다시 탐색하도록 한다.
				while (idx > 0 && target.charAt(i) != target.charAt(idx)) {
					idx = table[idx - 1];
				}
				if (target.charAt(i) == target.charAt(idx)) {
					idx++;
					table[i] = idx;
				}
			}

			idx = 0;
			int result = 0;
			for (int i = 0; i < str_len; i++) {
				// 일치하는 문자가 없고, 연속적으로 더 일치 하지 않으면 해당 테이블 인덱스 값을 idx에 저장해서 그 지점부터 다시 탐색하도록 한다.
				while (idx > 0 && str.charAt(i) != target.charAt(idx)) {
					idx = table[idx - 1];
				}
				if (str.charAt(i) == target.charAt(idx)) {
					if (idx == target_len - 1) {
						result++;
						idx = table[idx];
					} else {
						idx++;
					}
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
