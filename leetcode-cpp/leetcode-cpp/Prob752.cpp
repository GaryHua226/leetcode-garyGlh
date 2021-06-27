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
		// ȡ�������ײ���
		pair<string, int>& cur = q.front();
		string curString = cur.first;
		// ����������յ�
		if (curString == tar) {
			res = cur.second;
			break;
		}
		// ����ߵ��˲��ܶ��ĵ㣬�������Ѿ��߹��ĵ�
		if (deads.count(curString) || passed.count(curString)) {
			q.pop();
			continue;
		}
		passed.insert(cur.first);
		// ����8�����ܵ���ĵ�
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
		// ���������ײ���
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

