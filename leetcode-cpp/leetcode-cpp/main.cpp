#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;


static bool com_by_value(const pair<int, int>& lhs, const pair<int, int>& rhs) {
    return lhs.second > rhs.second;
}

int halfQuestions(vector<int>& questions) {
    int n = questions.size() / 2;
    map<int, int> mp;
    for (int i : questions) {
        if (mp.count(i)) {
            mp[i]++;
        }
        else {
            mp[i] = 1;
        }
    }
    vector<pair<int, int>> vec(mp.begin(), mp.end());
    sort(vec.begin(), vec.end(), com_by_value);
    int total = 0;
    for (int i = 0; i < vec.size(); i++) {
        total += vec[i].second;
        if (total >= n) {
            return i + 1;
        }
    }
    return n;
}

int main() {
    vector<int> ques = { 1,5,1,3,4,5,2,5,3,3,8,6 };
    halfQuestions(ques);
}