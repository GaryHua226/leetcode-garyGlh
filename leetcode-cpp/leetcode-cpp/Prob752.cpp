#include <iostream>
#include <vector>
#include <set>
#include <queue>

using namespace std;

set<string> deads;
set<string> passed;
string tar;
int res = -1;

void bfs(queue<pair<string, int>> q) {
	while (q.size() != 0) {
		// 取出队列首部的
		pair<string, int>& cur = q.front();
		string curString = cur.first;
		// 如果到达了终点
		if (curString == tar) {
			res = cur.second;
			break;
		}
		// 如果走到了不能动的点，或者是已经走过的点
		if (deads.count(curString) || passed.count(curString)) {
			q.pop();
			continue;
		}
		passed.insert(cur.first);
		// 遍历8个可能到达的点
		for (int i = 0; i < 4; i++) {
			char ch = curString[i];
			char low = (ch == '0' ? '9' : ch - 1);
			char high = (ch == '9' ? '0' : ch + 1);
			curString[i] = low;
			q.push(pair<string, int>(curString, cur.second + 1));
			curString[i] = high;
			q.push(pair<string, int>(curString, cur.second + 1));
			curString[i] = ch;
		}
		// 弹出队列首部的
		q.pop();
	}
}

int openLock(vector<string>& deadends, string target) {
	for (auto s : deadends) {
		deads.insert(s);
	}
	queue<pair<string, int>> q;
	q.push(pair<string, int>("0000", 0));
	tar = target;
	bfs(q);
	return res;
}

