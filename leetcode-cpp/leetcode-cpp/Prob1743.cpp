#include <iostream>
#include <vector>
#include <map>

using namespace std;

vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
	map<int, vector<int>> mp;
	for (auto p : adjacentPairs) {
		mp[p[0]].push_back(p[1]);
		mp[p[1]].push_back(p[0]);
	}
	vector<int> ret;
	int start;
	for (auto it = mp.begin(); it != mp.end(); it++) {
		if (it->second.size() == 1) {
			start = it->first;
			break;
		}
	}
	ret.push_back(start);
	ret.push_back(mp[start][0]);
	int lastlast = start;
	int last = mp[start][0];
	while (mp[last].size() != 1) {
		auto& v = mp[last];
		for (int next : v) {
			if (next != lastlast) {
				ret.push_back(next);
				lastlast = last;
				last = next;
				break;
			}
		}
	}
	return ret;
}