#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
	int m = grid.size();
	int n = grid[0].size();
	int totalLayer = min(m / 2, n / 2);
	for (int l = 0; l < totalLayer; l++) {
		vector<int> nums;
		// 上面的行
		for (int col = l; col <= n - l - 1; col++) {
			nums.push_back(grid[l][col]);
		}
		// 右边的列
		for (int row = l + 1; row <= m - l - 2; row++) {
			nums.push_back(grid[row][n - l - 1]);
		}
		// 下面的行
		for (int col = n - 1 - l; col >= l; col--) {
			nums.push_back(grid[m - 1 - l][col]);
		}
		// 左边的列
		for (int row = m - l - 2; row >= l + 1; row--) {
			nums.push_back(grid[row][l]);
		}
		// 进行旋转
		int idx = 0;
		int s = nums.size();
		// 上面的行
		for (int col = l; col <= n - l - 1; col++) {
			grid[l][col] = nums[(idx + k) % s];
			idx++;
		}
		// 右边的列
		for (int row = l + 1; row <= m - l - 2; row++) {
			grid[row][n-l-1] = nums[(idx + k) % s];
			idx++;
		}
		// 下面的行
		for (int col = n - 1 - l; col >= l; col--) {
			grid[m - 1 - l][col] = nums[(idx + k) % s];
			idx++;
		}
		// 左边的列
		for (int row = m - l - 2; row >= l + 1; row--) {
			grid[row][l] = nums[(idx + k) % s];
			idx++;
		}
	}
	// 返回结果
	return grid;
}