package 삼성DX알고리즘.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class passNode {
	public passNode next;
	public int data;

	passNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class No_6_암호문3 {
	static int nodeCnt = 0;
	static passNode head;
	static passNode tail;
	static ArrayList<passNode> node;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= 1; l++) {
			sb.append("#" + l + " ");
			int n = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			node = new ArrayList();
			init();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int password = Integer.parseInt(st.nextToken());
				if (i == 0) {
					head = getNode(password);
					tail = head;
					continue;
				}
				if (i == 1) {
					getNode(password);
					head.next = node.get(nodeCnt - 1);
					tail = head.next;
					continue;
				}

				getNode(password);
				node.get(nodeCnt - 2).next = node.get(nodeCnt - 1);
				tail = node.get(nodeCnt - 1);
			}

			int cmd_num = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmd_num; i++) {
				String cmd = st.nextToken();
				if (cmd == "I") {
					int target = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					insert(num, target, Integer.parseInt(st.nextToken()));
				} else if (cmd == "A") {
					int num = Integer.parseInt(st.nextToken());
					add(num);
				} else if (cmd == "D") {
					int target = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					romove(target, num);
				}
			}

			passNode result = head;
			for (int i = 0; i < 10; i++) {
				if(result == null) {
					break;
				}
				sb.append(result.data).append(" ");
				result = result.next;
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static void romove(int target, int num) {
		passNode temp = head;
		passNode nextNode = head;
		for (int i = 0; i < nodeCnt; i++) {
			if (temp.data == target) {
				nextNode = temp.next;
				nodeCnt--;
				for (int j = 1; j < num; j++) {
					nextNode = nextNode.next;
					nodeCnt--;
				}
				break;
			}
			temp = temp.next;
		}
		if (nextNode.next != null) {
			temp.next = nextNode.next;
		} else {
			tail = temp;
		}
	}

	private static void add(int num) {
		for (int i = 0; i < num; i++) {
			getNode(Integer.parseInt(st.nextToken()));
			if (i == 0) {
				tail.next = node.get(nodeCnt - 1);
				continue;
			}
			node.get(nodeCnt - 2).next = node.get(nodeCnt - 1);
		}
		tail = node.get(nodeCnt - 1);
	}

	private static passNode getNode(int data) {
		node.add(new passNode(data));
		return node.get(nodeCnt++);
	}

	private static void insert(int num, int target, int data) {
		passNode temp = head;
		getNode(data);
		for (int i = 0; i < nodeCnt; i++) {
			if (temp.data == target) {
				break;
			}
			temp = temp.next;
		}
		passNode nextNode = temp.next; // 기존 가리키는 다음 노드
		temp.next = node.get(nodeCnt - 1);
		for (int i = 1; i < num; i++) {
			getNode(Integer.parseInt(st.nextToken()));
			node.get(nodeCnt - 2).next = node.get(nodeCnt - 1);
		}

		if (nextNode == null) {
			tail = node.get(nodeCnt - 1);
		} else {
			node.get(nodeCnt - 1).next = nextNode;
		}
	}

	private static void init() {
		head = null;
		tail = null;
		nodeCnt = 0;
		return;
	}
}
