package D2;

import java.io.*;
import java.util.*;

public class ������369����_1926 {
	static String temp;
	static String result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			temp = String.valueOf(i);
			calc();
			
			if (result.contains("-")) {
				sb.append(result).append(" ");
			} else
				sb.append(temp).append(" ");
		}

		System.out.print(sb);

	}

	private static void calc() {
		result = "";
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '3' || temp.charAt(i) == '6' || temp.charAt(i) == '9') {
				result += "-";
			}
		}
	}

}

//��ü�� �ƴ� �Ϻκи� ġȯ �ϰ� �������� replace�� �� ����ϵ��� ����!
