#include<vector>
#include<iostream>

using namespace std;

void dfs(vector<vector<int>>& ans, vector<int>& nums, vector<int>& curList, int curIndex) {
	if (curIndex < nums.size()) {
		dfs(ans, nums, curList, curIndex + 1);
		curList.push_back(nums[curIndex]);
		dfs(ans, nums, curList, curIndex + 1);
		curList.pop_back();
	}
	else {
		ans.push_back(curList);
	}
}

vector<vector<int>> subsets(vector<int>& nums) {
	vector<vector<int>> res;
	vector<int> curList;
	dfs(res, nums, curList, 0);
	return res;
}

