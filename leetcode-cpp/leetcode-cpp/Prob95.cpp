#include "TreeNode.h"	
#include <vector>

using namespace std;

vector<TreeNode*> generateTrees_r(int start, int end) {
	// [start, end]Çø¼äµÄÊ÷
	if (start == end) {
		TreeNode* p = new TreeNode(start);
		return { p };
	} if (end - start == 1) {
		// start as root
		TreeNode* p1 = new TreeNode(end);
		TreeNode* q1 = new TreeNode(start, nullptr, p1);
		// end as root
		TreeNode* p2 = new TreeNode(start);
		TreeNode* q2 = new TreeNode(end, p2, nullptr);
		return { q1, q2 };
	}
	vector<TreeNode*> ret;
	// start as root
	vector<TreeNode*> rights = generateTrees_r(start + 1, end);
	for (auto r : rights) {
		TreeNode* p = new TreeNode(start, nullptr, r);
		ret.push_back(p);
	}
	// end as root
	vector<TreeNode*> lefts = generateTrees_r(start, end - 1);
	for (auto l : lefts) {
		TreeNode* p = new TreeNode(end, l, nullptr);
		ret.push_back(p);
	}
	// middle number as root
	for (int root = start + 1; root <= end - 1; root++) {
		vector<TreeNode*> leftTrees = generateTrees_r(start, root - 1);
		vector<TreeNode*> rightTrees = generateTrees_r(root + 1, end);
		for (auto left : leftTrees) {
			for (auto right : rightTrees) {
				TreeNode* p = new TreeNode(root, left, right);
				ret.push_back(p);
			}
		}
	}
	return ret;
}

vector<TreeNode*> generateTrees(int n) {
	return generateTrees_r(1, n);
}