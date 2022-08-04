package �ＺDX�˰���.����Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_41_�к��̺�Ʈ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			long n = Long.parseLong(br.readLine()); // �кҰ���
			if (n == 1) {
				sb.append(1).append("\n");
				continue;
			}

			long layer = -1;
			for (long i = (long) Math.sqrt(2 * n); i < n; i++) {
				long temp = ((i * (i + 1)) / 2);
				if (temp == n) {
					layer = i;
					break;
				} else if (temp > n) {
					break;
				}
			}
			sb.append(layer).append("\n");
		}
		System.out.println(sb);
	}

}
