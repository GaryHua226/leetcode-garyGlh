#include <iostream>
#include <set>
#include <vector>
#include <map>

using namespace std;

int a[100000+1];

bool legal(int a) {
	// a的二进制中至多只存在一个1
	return a == 0 || (a & (a - 1)) == 0;
}

long long wonderfulSubstrings(string word) {
	int n = word.length();
	a[0] = 0;
	for (int i = 0; i < n; i++) {
		a[i + 1] = a[i] ^ (1 << (word[i] - 'a'));
	}
	long long cnt = 0;
	map<int, int> m;
	m[0] = 1;
	for (int i = 1; i <= n; i++) {
		// 要看map中是否有能够和a[i]组合成最多只有一个1的数字
		// 看有没有能够变成0的
		if (m.count(a[i])) {
			cnt += m[a[i]];
		}
		// 看有没有能够变成只有一个1的
		for (int j = 0; j < 10; j++) {
			// 依次翻转每一位
			int tmp = a[i] ^ (1 << j);
			if (m.count(tmp)) {
				cnt += m[tmp];
			}
		}
		// 将当前数字放进去
		if (m.count(a[i])) {
			m[a[i]] = m[a[i]] + 1;
		}
		else {
			m[a[i]] = 1;
		}
	}
	return cnt;
}