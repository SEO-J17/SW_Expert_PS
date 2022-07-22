package 삼성DX알고리즘.그래프;

public class NO_14_UserSolution {
	static int arr[][];
	static int grade;
	static boolean isFind;

	public void dfs_init(int n, int[][] path) {
		arr = new int[100][5];
		for (int i = 0; i < path.length; i++) {
			int parent = path[i][0];
			if (parent == 0 && path[i][1] == 0) {
				return;
			}
			for (int j = 0; j < 5; j++) {
				if (arr[parent][j] == 0) {
					arr[parent][j] = path[i][1];
					break;
				}
			}
		}
	}

	public int dfs(int N) {
		grade = N;
		isFind = false;
		calc(N);
		if (grade == N) {
			return -1;
		} else {
			return grade;
		}
	}

	private void calc(int n) {
		for (int i = 0; i < 5; i++) {
			if (isFind == true) {
				return;
			}
			if (arr[n][i] > grade) {
				isFind = true;
				grade = arr[n][i];
				return;
			}
			if (arr[n][i] != 0 && arr[n][i] <= grade) {
				calc(arr[n][i]);
			}

		}
	}

}
