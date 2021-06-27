#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

int slidingPuzzle(vector<vector<int>>& board) {
	// 0, 1, 2 
	// 3, 4, 5
	vector<vector<int>> cor = {
		{1, 3},
		{0, 2, 4},
		{1, 5},
		{0, 4},
		{1, 3, 5},
		{2, 4}
	};
	string target = "123450";
	string curString;
	set<string> passed;
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 3; j++) {
			curString += 'a' + board[i][j];
		}
	}
	queue<pair<string, int>> q;
	q.push(pair<string, int>(curString, 0));
	while (q.size() != 0) {
		pair<string, int> p = q.front();
		q.pop();
		curString = p.first;
		if (passed.count(curString)) {
			continue;
		}
		passed.insert(curString);
		if (curString == target) {
			return p.second;
		}
		int index = curString.find_first_of('0');
		for (int i = 0; i < cor[index].size(); i++) {
			int swapIndex = cor[index][i];
			string nextString = curString;
			nextString[index] = nextString[swapIndex];
			nextString[swapIndex] = '0';
			q.push(pair<string, int>(nextString, p.second + 1));
		}
	}
	return -1;
}