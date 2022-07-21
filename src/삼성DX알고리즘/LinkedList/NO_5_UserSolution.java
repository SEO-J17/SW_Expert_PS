package 삼성DX알고리즘.LinkedList;

class Nodes {
	public int data;
	public Nodes prev;
	public Nodes next;

	public Nodes(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class NO_5_UserSolution {

	private final static int MAX_NODE = 10000;

	private Nodes[] node = new Nodes[MAX_NODE];
	private int nodeCnt = 0;
	private Nodes head;
	private Nodes tail;

	public Nodes getNode(int data) {
		node[nodeCnt] = new Nodes(data);
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
			Nodes current_node = head;
			head = node[nodeCnt - 1];
			head.next = current_node;
			current_node.prev = head;
		}
	}

	public void addNode2Tail(int data) {
		if (tail == null) {
			addNode2Head(data);
			return;
		}
		getNode(data);
		Nodes current = tail; // 기존 테일노드
		tail.next = node[nodeCnt - 1]; // 기존 tail의 next값을 새로 들어온 노드로 집어 넣는다
		tail = node[nodeCnt - 1];
		tail.prev = current;
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
			Nodes current = head;
			node[nodeCnt - 1].next = current;
			head = node[nodeCnt - 1];
			current.prev = head;
			return;
		}

		Nodes current = head;
		Nodes before = null;
		for (int i = 0; i < nodeCnt; i++) {
			if (i + 1 == num) {
				break;
			}
			before = current;
			current = current.next;
		}

		before.next = node[nodeCnt - 1];
		current.prev = node[nodeCnt - 1];
		node[nodeCnt - 1].next = current;
		node[nodeCnt - 1].prev = before;
	}

	public int findNode(int data) {
		if (tail.data == data) {
			return nodeCnt;
		}

		Nodes current = head;
		int idx = 0;
		for (int i = 0; i < nodeCnt; i++) {
			if (current.data == data) {
				idx = i + 1;
				break;
			}
			current = current.next;
		}

		return idx;
	}

	public void removeNode(int data) {
		if (nodeCnt == 0) {
			return;
		}

		if (head.data == data) {
			head = head.next;
			nodeCnt--;
			return;
		}

		Nodes current = head;
		Nodes before = current;
		boolean flag = false;
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
				tail.next = null;
				return;
			}
			before.next = current.next;
			current.next.prev = before;
			current = null;
			nodeCnt--;
		}
	}

	public int getList(int[] output) {
		int idx = 0;
		Nodes temp = head;

		for (int i = 0; i < nodeCnt; i++) {
			if (temp != null) {
				idx++;
				output[i] = temp.data;
				temp = temp.next;
			}
		}
		return idx;
	}

	public int getReversedList(int[] output) {
		int idx = 0;
		Nodes temp = tail;

		for (int i = 0; i < nodeCnt; i++) {
			if (temp != null) {
				idx++;
				output[i] = temp.data;
				temp = temp.prev;
			}
		}

		return idx;
	}
}
