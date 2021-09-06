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
			calc(1, arr[0]);
		}

	}

	private static void calc(int depth, int value) {
		if (depth == num) {
			return;
		}

		if (value > arr[depth]) {
			max = arr[depth];
			calc(depth + 1, arr[depth]);
		}else if(value <= arr[depth]) {
			calc(depth+1, value);
		}

	}
}
