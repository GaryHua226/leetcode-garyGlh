#include <iostream>
#include <set>
#include <vector>
#include <map>

using namespace std;

int a[100000+1];

bool legal(int a) {
	// a�Ķ�����������ֻ����һ��1
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
		// Ҫ��map���Ƿ����ܹ���a[i]��ϳ����ֻ��һ��1������
		// ����û���ܹ����0��
		if (m.count(a[i])) {
			cnt += m[a[i]];
		}
		// ����û���ܹ����ֻ��һ��1��
		for (int j = 0; j < 10; j++) {
			// ���η�תÿһλ
			int tmp = a[i] ^ (1 << j);
			if (m.count(tmp)) {
				cnt += m[tmp];
			}
		}
		// ����ǰ���ַŽ�ȥ
		if (m.count(a[i])) {
			m[a[i]] = m[a[i]] + 1;
		}
		else {
			m[a[i]] = 1;
		}
	}
	return cnt;
}