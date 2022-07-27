package �ＺDX�˰���.�ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NO_26_�ܾ�����ϴ�Ƚ�� {
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
			int table[] = new int[target_len]; // ���̻��̸鼭 ���λ��� �ִ� ���ڿ� ���̸� �����ϴ� �迭,�κ� ��ġ ���̺� �̶�� �Ѵ�.

			int idx = 0;
			for (int i = 1; i < target_len; i++) {
				// ��ġ�ϴ� ���ڰ� ����, ���������� �� ��ġ ���� ������ �ش� ���̺� �ε��� ���� idx�� �����ؼ� �� �������� �ٽ� Ž���ϵ��� �Ѵ�.
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
				// ��ġ�ϴ� ���ڰ� ����, ���������� �� ��ġ ���� ������ �ش� ���̺� �ε��� ���� idx�� �����ؼ� �� �������� �ٽ� Ž���ϵ��� �Ѵ�.
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
