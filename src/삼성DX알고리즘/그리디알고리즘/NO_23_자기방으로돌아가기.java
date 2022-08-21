package 삼성DX알고리즘.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_23_자기방으로돌아가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			int n = Integer.parseInt(br.readLine());
			int corridor[] = new int[201];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int room1 = (Integer.parseInt(st.nextToken()) + 1) / 2;
				int room2 = (Integer.parseInt(st.nextToken()) + 1) / 2;
				if (room1 > room2) {
					for (int j = room2; j <= room1; j++) {
						corridor[j]++;
					}
				} else {
					for (int j = room1; j <= room2; j++) {
						corridor[j]++;
					}
				}
			}
			Arrays.sort(corridor);
			sb.append(corridor[200]).append("\n");
		}
		System.out.println(sb);
	}
}
