#include<vector>
#include<iostream>
#include<unordered_map>
using namespace std;

// 找数组中和为k的子数组数目
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
	// 枚举上边界
	for (int i = 0; i < m; i++) {
		vector<int> sum(n);
		// 枚举下边界
		for (int j = ; j < m; j++) {
			// 更新每列的元素和
			for (int c = 0; c < n; c++) {
				sum[c] += matrix[j][c];
			}
			ans += subarraySum(sum, target);
		}
	}
	return ans;
}