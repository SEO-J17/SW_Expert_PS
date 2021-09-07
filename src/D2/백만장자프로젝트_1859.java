package D2;

import java.io.*;
import java.util.*;

public class 백만장자프로젝트_1859 {
	static int n;
	static int arr[];
	static int num;
	static int max = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			num = sc.nextInt();
			arr = new int[num];
			for (int j = 0; j < num; j++) {
				arr[j] = sc.nextInt();
			}
			sb.append("#" + (i + 1) + " ");
			calc();
		}

		System.out.println(sb);

	}

	private static void calc() {
		max = arr[num - 1];
		long result = 0; // 백만이 넘어가기 떄문에 long타입을 써야된다!! 타입 신경쓰기
		for (int i = num - 2; i >= 0; i--) {
			if (arr[i] < max) {
				result += (max - arr[i]);
			} else if (arr[i] > max) {
				max = arr[i];
			} else
				continue;
		}
		sb.append(result).append("\n");
	}

}
