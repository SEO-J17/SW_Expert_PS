package 삼성DX알고리즘;

class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class NO_4_UserSolution {
	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;
	private Node tail;

	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {
		head = null;
		tail = null;
		nodeCnt = 0;
	}

	public void addNode2Head(int data) {
		if (nodeCnt == 0) {
			head = getNode(data);
			tail = head;
		} else {
			getNode(data);
			Node current_node = head;
			head = node[nodeCnt - 1];
			head.next = current_node;
		}
	}

	public void addNode2Tail(int data) {
		if (tail == null) {
			addNode2Head(data);
			return;
		}
		getNode(data);
		tail.next = node[nodeCnt - 1];
		tail = node[nodeCnt - 1];
	}

	public void addNode2Num(int data, int num) {
		if (nodeCnt == 0) {
			addNode2Head(data);
			return;
		}

		if (num > nodeCnt) {
			addNode2Tail(data);
			return;
		}

		getNode(data);

		if (num == 1) {
			Node current = head;
			node[nodeCnt - 1].next = current;
			head = node[nodeCnt - 1];
			return;
		}

		Node current = head;
		Node before = null;
		for (int i = 0; i < nodeCnt; i++) {
			if (i + 1 == num) {
				break;
			}
			before = current;
			current = current.next;
		}

		before.next = node[nodeCnt - 1];
		node[nodeCnt - 1].next = current;

	}

	public void removeNode(int data) {
		if (nodeCnt == 0) {
			return;
		}

		boolean flag = false;
		if (head.data == data) {
			head = head.next;
			nodeCnt--;
			return;
		}

		Node current = head;
		Node before = current;

		for (int i = 0; i < nodeCnt; i++) {
			if (current.data == data) {
				flag = true;
				break;
			}
			before = current;
			current = current.next;
		}

		if (flag) {
			if (tail == current) {
				tail = before;
			}
			before.next = current.next;
			current = null;
			nodeCnt--;
		}

	}

	public int getList(int[] output) {
		int idx = 0;
		Node temp = head;

		for (int i = 0; i < nodeCnt; i++) {
			if (temp != null) {
				idx++;
				output[i] = temp.data;
				temp = temp.next;
			}
		}

		return idx;
	}
}
