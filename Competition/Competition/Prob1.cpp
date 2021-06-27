#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int maxProductDifference(vector<int>& nums) {
	sort(nums.begin(), nums.end());
	long a, b, c, d;
	a = nums[0];
	b = nums[1];
	int n = nums.size();
	c = nums[n - 2];
	d = nums[n - 1];
	return c * d - a * b;
}

