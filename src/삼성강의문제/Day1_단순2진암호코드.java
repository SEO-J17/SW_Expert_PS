package 삼성강의문제;

import java.io.*;
import java.util.*;

public class Day1_단순2진암호코드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			String str = "";
			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				if (!temp.contains("1")) {
					continue;
				}
				for (int j = temp.length() - 1; j >= 0; j--) {
					if (temp.charAt(j) == '1') {
						str = temp.substring(j - 55, j + 1);
						break;
					}
				}
			}

			str = findCode(str);

			int result = ((str.charAt(0) - '0') + (str.charAt(2) - '0') + (str.charAt(4) - '0') + (str.charAt(6) - '0'))
					* 3 + (str.charAt(1) - '0') + (str.charAt(3) - '0') + (str.charAt(5) - '0') + (str.charAt(7) - '0');
			
			if (result % 10 == 0) {
				result = (str.charAt(0) - '0') + (str.charAt(2) - '0') + (str.charAt(4) - '0') + (str.charAt(6) - '0')
						+ (str.charAt(1) - '0') + (str.charAt(3) - '0') + (str.charAt(5) - '0') + (str.charAt(7) - '0');
				sb.append(result).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);

	}

	private static String findCode(String code) {
		String str = "";
		for (int i = 0; i < code.length(); i += 7) {
			String temp = code.substring(i, i + 7);
			if (temp.equals("0001101")) {
				str += "0";
			} else if (temp.equals("0011001")) {
				str += "1";
			} else if (temp.equals("0010011")) {
				str += "2";
			} else if (temp.equals("0111101")) {
				str += "3";
			} else if (temp.equals("0100011")) {
				str += "4";
			} else if (temp.equals("0110001")) {
				str += "5";
			} else if (temp.equals("0101111")) {
				str += "6";
			} else if (temp.equals("0111011")) {
				str += "7";
			} else if (temp.equals("0110111")) {
				str += "8";
			} else if (temp.equals("0001011")) {
				str += "9";
			}
		}
		return str;
	}
}
