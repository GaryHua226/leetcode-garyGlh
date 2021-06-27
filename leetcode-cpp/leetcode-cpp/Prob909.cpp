#include <vector>
#include <set>
#include <queue>
#include <iostream>

using namespace std;

int snakesAndLadders(vector<vector<int>>& board) {
	int n = board.size();
	vector<int> m(n * n);
	int idx = 0;
	for (int row = 0; row < n; row++) {
		// ��������
		if (row % 2 == 0) {
			for (int col = 0; col < n; col++) {
				m[idx++] = board[n - 1 - row][col] - 1;
			}
		}
		// ��������
		else {
			for (int col = n - 1; col >= 0; col--) {
				m[idx++] = board[n - 1 - row][col] - 1;
			}
		}
	}
	// ��ʼbfsѰ�Ҵ�
	set<int> passed; // ��¼������ĵ�
	queue<pair<int, int>> q; // ����
	q.push(pair<int, int>(0, 0));
	while (q.size() != 0) {
		pair<int, int> p = q.front();
		q.pop();
		int curLocation = p.first;
		// �����Ƿ��Ѿ����������ط�
		if (passed.count(curLocation)) {
			continue;
		}
		passed.insert(curLocation);
		// �����Ƿ��Ѿ������յ�
		if (curLocation == n * n - 1) {
			return p.second;
		}
		// bfs��һ��λ��
		for (int i = 1; i <= 6; i++) {
			if (curLocation + i < n * n) {
				if (m[curLocation + i] == -2) {
					q.push(pair<int, int>(curLocation + i, p.second + 1));
				}
				else {
					q.push(pair<int, int>(m[curLocation + i], p.second + 1));
				}
			}
			else {
				break;
			}
			
		}
	}
	return -1;
}

int main() {
	vector<vector<int>> board = {
		{-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1},
		{-1,35,-1,-1,13,-1},
		{-1,-1,-1,-1,-1,-1},
		{-1,15,-1,-1,-1,-1}
	};
	int ans = snakesAndLadders(board);
	cout << ans << endl;
}