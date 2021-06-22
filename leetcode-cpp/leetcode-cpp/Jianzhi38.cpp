#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

void dfs(vector<char>& cur, int curIndex, vector<bool>& flag, vector<char>& allChars, set<string>& answer) {
	if (curIndex == allChars.size()) {
		string s;
		for (int i = 0; i < cur.size(); i++) {
			s += cur[i];
		}
		answer.insert(s);
		return;
 	}
	for (int i = 0; i < allChars.size(); i++) {
		if (!flag[i]) {
			flag[i] = true;
			cur[curIndex] = allChars[i];
			dfs(cur, curIndex + 1, flag, allChars, answer);
			flag[i] = false;
		}
	}
}

vector<string> permutation(string s) {
	vector<char> allChars(s.length());
	for (int i = 0; i < s.length(); i++) {
		allChars[i] = s[i];
	}
	sort(allChars.begin(), allChars.end());
	set<string> answer;
	vector<char> cur(s.length());
	vector<bool> flag(s.length());
	dfs(cur, 0, flag, allChars, answer);
	vector<string> res;
	for (auto s : answer) {
		res.push_back(s);
	}
	return res;
}
 