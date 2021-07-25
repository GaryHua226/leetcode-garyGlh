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

void exchange(TreeNode* root, int x, int y) {
	if (root == nullptr) {
		return;
	}
	if (root->val = x) {
		root->val = y;
	}
	else if (root->val == y) {
		root->val = x;
	}
	exchange(root->left, x, y);
	exchange(root->right, x, y);
}

void recoverTree(TreeNode* root) {
	vector<int> nums;
	in(root, nums);
	vector<int> a;
	for (int i = 0; i < nums.size() - 1; i++) {
		if (nums[i] > nums[i + 1]) {
			a.push_back(nums[i]);
			a.push_back(nums[i + 1]);
		}
	}
	if (a.size() == 2) {
		exchange(root, a[0], a[1]);
	}
	else if (a.size() == 4) {
		exchange(root, a[0], a[3]);
	}
}