#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <set>
#include <unordered_map>

using namespace std;

int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
    if (source == target) {
        return 0;
    }

    int n = routes.size();
    vector<vector<int>> edge(n, vector<int>(n));
    unordered_map<int, vector<int>> rec;
    for (int i = 0; i < n; i++) {
        for (auto& site : routes[i]) {
            for (auto& j : rec[site]) {
                edge[i][j] = edge[j][i] = true;
            }
            rec[site].push_back(i);
        }
    }

    vector<int> dis(n, -1);
    queue<int> que;
    for (auto& site : rec[source]) {
        dis[site] = 1;
        que.push(site);
    }
    while (!que.empty()) {
        int x = que.front();
        que.pop();
        for (int y = 0; y < n; y++) {
            if (edge[x][y] && dis[y] == -1) {
                dis[y] = dis[x] + 1;
                que.push(y);
            }
        }
    }

    int ret = INT_MAX;
    for (auto& site : rec[target]) {
        if (dis[site] != -1) {
            ret = min(ret, dis[site]);
        }
    }
    return ret == INT_MAX ? -1 : ret;
}