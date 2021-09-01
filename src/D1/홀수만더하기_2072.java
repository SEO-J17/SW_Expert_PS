package D1;

import java.io.*;
import java.util.*;

public class 홀수만더하기_2072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= t; i++) {
			int temp = 0;
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				temp = sc.nextInt();
				if (temp % 2 != 0) {
					sum += temp;
				}
			}
			
			sb.append("#" + i + " ").append(sum).append("\n");
			
		}

		System.out.print(sb);

	}
}
