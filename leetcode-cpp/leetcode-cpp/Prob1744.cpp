#include<vector>

using namespace std;

vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
    int m = candiesCount.size();
    int n = queries.size();
    vector<bool> res;
    vector<unsigned long> pre(m + 1);
    pre[0] = 0;
    for (int i = 1; i <= m; i++) {
        pre[i] = pre[i - 1] + candiesCount[i - 1];
    }
    for (auto& q : queries) {
        int type = q[0];
        unsigned long day = q[1] + 1;
        unsigned long daily = q[2];
        unsigned long minNum = day; // 最少能吃多少颗
        unsigned long maxNum = daily * day; // 最多能吃多少颗
        if (minNum <= pre[type + 1] && pre[type] < maxNum) {
            res.push_back(true);
        }
        else {
            res.push_back(false);
        }
    }
    return res;
}