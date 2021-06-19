#include <cstdio>
#include <vector>
#include <iostream>

using namespace std;

int numSquares(int n) {
	vector<int> dp(n + 1);
	dp[0] = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; ; j++) {
			if (i - j * j >= 0) {
				if (dp[i] == 0 || dp[i] > dp[i - j * j ] +1)
					dp[i] = dp[i - j * j] + 1;
			}
			else {
				break;
			}
		}
	}
	return dp[n];
}

/*
int main() {
	int n;
	scanf("%d", &n);
	int res = numSquares(n);
	printf("%d\n", res);
	return 0;
}
*/