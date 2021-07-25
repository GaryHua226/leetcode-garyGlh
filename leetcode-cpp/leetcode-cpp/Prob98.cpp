#include "TreeNode.h"
#include <vector>

using namespace std;

void in(TreeNode* root, vector<int>& nums) {
	if (root == nullptr) {
		return;
	}
	in(root->left, nums);
	nums.push_back(root->val);
	in(root->right, nums);
}

bool isValidBST(TreeNode* root) {
	vector<int> inOrder;
	in(root, inOrder);
	for (int i = 0; i < inOrder.size() - 1; i++) {
		if (inOrder[i] >= inOrder[i + 1]) {
			return false;
		}
	}
	return true;
}