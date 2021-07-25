#include "TreeNode.h"
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>> list;
    vector<int> temp;
    queue<TreeNode*> q;
    int size;
    TreeNode* p;
    if (root == NULL) {
        return list;
    }
    q.push(root);
    while (!q.empty()) {
        size = q.size();
        temp.clear();
        for (int i = 0; i < size; i++) {
            p = q.front();
            temp.push_back(p->val);
            if (p->left) q.push(p->left);
            if (p->right) q.push(p->right);
            q.pop();
        }
        list.push_back(temp);
    }
    return list;
}