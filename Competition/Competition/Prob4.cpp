#include <vector>
#include <iostream>
#include <map>

using namespace std;

int waysToBuildRooms(vector<int>& prevRoom) {
	map<int, vector<int>> m;
	m[0] = {};
	for (int i = 1; i < prevRoom.size(); i++) {
		if (m.count(prevRoom[i])) {
			m[prevRoom[i]].push_back(i);
		}
		else {
			m[prevRoom[i]] = { i };
		}
	}
	return -1;
}

int main() {
	vector<int> prevRoom = { -1, 0, 0, 1, 2 };
	waysToBuildRooms(prevRoom);
}