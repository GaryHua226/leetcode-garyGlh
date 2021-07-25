#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int numWays(int n, vector<vector<int>>& relation, int k) {
	vector<vector<int>> graph(n);
	for (auto rel : relation) {
		graph[rel[0]].push_back(rel[1]);
	}
	// bfs
	queue<pair<int, int>> q;
	q.push(pair<int, int>(0, 0));
	int cnt = 0;
	while (q.size() != 0) {
		pair<int, int> p = q.front();
		q.pop();
		if (p.second == k) {
			if (p.first == n - 1) {
				cnt++;
			}
			continue;
		}
		for (int next : graph[p.first]) {
			q.push(pair<int, int>(next, p.second + 1));
		}
	}
	return cnt;
}

int main() {
	vector<vector<int>> relations = {
		{0,2} ,{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}
	};
	numWays(5, relations, 3);
}