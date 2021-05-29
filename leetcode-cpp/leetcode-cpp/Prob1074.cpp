#include<vector>
#include<iostream>
#include<unordered_map>
using namespace std;

// �������к�Ϊk����������Ŀ
int subarraySum(vector<int>& nums, int k) {
	unordered_map<int, int> map;
	map[0] = 1;
	int count = 0, pre = 0;
	for (auto& x : nums) {
		pre += x;
		if (map.find(pre - k) != map.end()) {
			count += map[pre - k];
		}
		map[pre]++;
	}
	return count;
}

int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
	int ans = 0;
	int m = matrix.size(), n = matrix[0].size();
	// ö���ϱ߽�
	for (int i = 0; i < m; i++) {
		vector<int> sum(n);
		// ö���±߽�
		for (int j = ; j < m; j++) {
			// ����ÿ�е�Ԫ�غ�
			for (int c = 0; c < n; c++) {
				sum[c] += matrix[j][c];
			}
			ans += subarraySum(sum, target);
		}
	}
	return ans;
}