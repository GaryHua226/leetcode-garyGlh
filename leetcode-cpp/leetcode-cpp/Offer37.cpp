#include <iostream>
#include <string>
#include "TreeNode.h"

using namespace std;

class TreeSerialize {
private:
	int index;
public:

	// Encodes a tree to a single string
	string serialize(TreeNode* root) {
		string encodedTree;
		serialize_r(root, encodedTree);
		return encodedTree;
	}

	void serialize_r(TreeNode* root, string& cur) {
		if (root == nullptr) {
			cur += "#";
			return;
		}
		cur += to_string(root->val) + ",";
		serialize_r(root->left, cur);
		serialize_r(root->right, cur);
	}

	// Decodes your encoded data to tree
	TreeNode* deserialize(string data) {
		if (data.length() == 0) {
			return nullptr;
		}
		index = 0;
		return deserialize_r(data);
	}

	TreeNode* deserialize_r(string data) {
		if (data[index] == '#') {
			index++;
			return nullptr;
		}
		int val = 0;
		bool pos = true;
		if (data[index] == '-') {
			pos = false;
			index++;
		}
		while (data[index] != ',') {
			val *= 10;
			val += data[index] - '0';
			index++;
		}
		if (!pos) {
			val *= -1;
		}
		index++;
		TreeNode *root = new TreeNode(val);
		root->left = deserialize_r(data);
		root->right = deserialize_r(data);
		return root;
	}
};