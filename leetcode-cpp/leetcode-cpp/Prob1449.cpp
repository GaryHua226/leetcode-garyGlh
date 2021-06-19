#include <iostream>
#include <cstdlib>
#include <string>
#include <vector>
#include <map>
using namespace std;

// �ж�s1�Ƿ��s2Ҫ��
bool cmp(string& s1, string& s2) {
	if (s1.length() > s2.length()) {
		return true;
	}
	else if (s1.length() < s2.length()) {
		return false;
	}
	for (int i = 0; i < s1.length(); i++) {
		if (s1[i] > s2[i]) {
			return true;
		}
		else if (s1[i] < s2[i]) {
			return false;
		}
	}
	return false;
}

string largestNumber(vector<int>& cost, int target) {
	// ��Ҫ���ҳ�ÿ��cost��Ӧ���������֣��޳�����Щ��ͬcost������ֵ��С��
	map<int, int> m;
	for (int i = 0; i < cost.size(); i++) {
		m[cost[i]] = i + 1;
	}
	vector<string> dp(target + 1);
	dp[0] = "";
	for (int i = 1; i <= target; i++) {
		for (auto it = m.begin(); it != m.end(); it++) {
			if (i - it->first >= 0) {
				string last = dp[i - it->first];
				if (last.length() == 0 && i - it->first != 0) {
					continue;
				}
				char insert = it->second + '0';
				// ������Ҫ��insert����ֵ����last�У���ʹ��last�ܹ����
				string next;
				int idx = 0;
				for (; idx < last.length(); idx++) {
					if (last[idx] > insert) {
						next = next + last[idx];
					}
					else {
						break;
					}
				}
				next = next + insert;
				for (; idx < last.length(); idx++) {
					next = next + last[idx];
				}
				// ������Ҫ�Ƚ�
				if (cmp(next, dp[i])) {
					dp[i] = next;
				}
			}
			else {
				break;
			}
		}
	}
	if (dp[target].length() != 0) {
		cout << dp[target] << endl;
		return dp[target];
	}
	else {
		cout << "0" << endl;
		return "0";
	}
}

int main() {
	vector<int> cost = { 6,10,15,40,40,40,40,40,40 };
	int target = 47;
	largestNumber(cost, target);
}