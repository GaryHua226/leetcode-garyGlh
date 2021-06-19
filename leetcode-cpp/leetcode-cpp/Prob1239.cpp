#include <vector>
#include <iostream>

using namespace std;

int getLength(int n) {
	int cnt = 0;
	while (n != 0) {
		cnt++;
		n &= (n - 1);
	}
	return cnt;
}

int dfs(vector<int>& arr, int curIndex, int mask) {
	int res = getLength(mask);
	for (int i = curIndex; i < arr.size(); i++) {
		if (arr[i] & mask) {
			continue;
		}
		int tmp = dfs(arr, i + 1, mask | arr[i]);
		if (tmp > res) {
			res = tmp;
		}
	}
	return res;
}

int maxLength(vector<string>& arr) {
	// step1: convert each string to a int
	vector<int> convertedArr;
	for (string str : arr) {
		int t = 0;
		for (int i = 0; i < str.length(); i++) {
			// if this character has occured before
			if (t & (1 << (str[i] - 'a'))) {
				break;
			}
			t |= 1 << (str[i] - 'a');
			if (i == str.length() - 1) {
				convertedArr.push_back(t);
			}
		}
	}
	// step2: dfs 
	int res = dfs(convertedArr, 0, 0);
	cout << res << endl;
	return res;
}