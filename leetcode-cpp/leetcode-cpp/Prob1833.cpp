#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int maxIceCream(vector<int>& costs, int coins) {
	sort(costs.begin(), costs.end());
	int sum = 0;
	int idx;
	for (idx = 0; idx < costs.size(); idx++) {
		if (sum > coins) {
			break;
		}
		sum += costs[idx];
	}
	return idx;
}