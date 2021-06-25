#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int gcd(int a, int b) {
    return b ? gcd(b, a % b) : a;
}

int maxPoints(vector<vector<int>>& points) {
    int n = points.size();
    if (n <= 2) {
        return n;
    }
    int ret = 0;
    for (int i = 0; i < n; i++) {
        if (ret >= n - 1 || ret > n / 2) {
            break;
        }
        unordered_map<int, int> mp;
        for (int j = i + 1; j < n; j++) {
            int x = points[i][0] - points[j][0];
            int y = points[i][1] - points[j][1];
            if (x == 0) {
                y = 1;
            }
            else if (y == 0) {
                x = 1;
            }
            else {
                if (y < 0) {
                    x = -x;
                    y = -y;
                }
                int gcdXY = gcd(abs(x), abs(y));
                x /= gcdXY, y /= gcdXY;
            }
            int maxn = 0;
            for (auto it = mp.begin(); it != mp.end(); it++) {
                maxn = max(maxn, it->first + 1);
            }
            ret = max(ret, maxn);
        }
        return ret;
    }
}