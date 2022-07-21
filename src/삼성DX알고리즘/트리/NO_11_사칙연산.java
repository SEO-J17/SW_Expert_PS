package �ＺDX�˰���.Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NO_11_��Ģ���� {
	static int node[][];
	static String data[];
	static Stack<Double> stack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= 10; l++) {
			sb.append("#" + l + " ");
			int n = Integer.parseInt(br.readLine());
			node = new int[n + 1][2];
			data = new String[n + 1];
			stack = new Stack();

			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split(" ");
				int target = Integer.parseInt(temp[0]);
				data[target] = temp[1];
				if (temp.length == 4) {
					node[target][0] = Integer.parseInt(temp[2]);
					node[target][1] = Integer.parseInt(temp[3]);
				}
			}

			calc(1);

			sb.append(stack.pop().intValue()).append("\n");
		}

		System.out.println(sb);

	}

	private static void calc(int idx) {
		if (node[idx][0] == 0 && node[idx][1] == 0) { // ���ܳ���� ���.
			search(data[idx]);
		} else {
			if (node[idx][0] != 0) {
				calc(node[idx][0]);
			}
			if (node[idx][1] != 0) {
				calc(node[idx][1]);
			}
			search(data[idx]);
		}
	}

	private static void search(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {		//�������ϰ�� ���ÿ� �����ʰ� ���ÿ� ���� ���� ���
			Double num2 = stack.pop();	//�����̹Ƿ� ���� ����ؾߵɰ��� �ڿ��ִ�.
			Double num1 = stack.pop();

			if (str.equals("+")) {
				stack.push(num1 + num2);
			} else if (str.equals("-")) {
				stack.push(num1 - num2);
			} else if (str.equals("/")) {
				stack.push(num1 / num2);
			} else if (str.equals("*")) {
				stack.push(num1 * num2);
			}
		} else {
			stack.push(Double.parseDouble(str));	//������ �ƴҰ�� ���ÿ� push.
		}
	}
}
