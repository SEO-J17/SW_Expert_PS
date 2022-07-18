package D2;

import java.io.*;
import java.util.*;

public class 패턴마디의길이_2007 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = "";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			sb.append("#" + (i + 1)).append(" ");
			str = sc.next();
			int j = 0;
			int k = 1;
			for (k = 1; k < str.length(); k++) {
				if (str.charAt(j) == str.charAt(k)) {
					j++;
				} else
					j = 0;
			}
			sb.append((k - j) + "\n");
		}

		System.out.println(sb);
	}

}
