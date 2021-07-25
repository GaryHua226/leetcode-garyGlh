#include <vector>

using namespace std;

int numTrees(int n) {
	vector<int> dp(n);
	if (n == 1) {
		return 1;
	}
	else if (n == 2) {
		return 2;
	}
	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 1;
	for (int i = 3; i < n; i++) {
		for (int k = 0; k < i - 1; k++) {
			dp[i] += dp[k] * dp[i - 1 - k];
		}
	}
	return dp[n - 1];
}