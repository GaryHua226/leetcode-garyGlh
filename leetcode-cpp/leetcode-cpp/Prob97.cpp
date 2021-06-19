#include<iostream>

using namespace std;

bool isInterleave_r(string& s1, string& s2, string& s3, int idx1, int idx2, int idx3) {
    bool flag1 = false, flag2 = false;
    if (idx1 == s1.size() && idx2 == s2.size() && idx3 == s3.size()) {
        return true;
    }
    if (idx1 < s1.size() && s1[idx1] == s3[idx3]) {
        flag1 = isInterleave_r(s1, s2, s3, idx1 + 1, idx2, idx3 + 1);
    }
    if (idx2 < s2.size() && s2[idx2] == s3[idx3]) {
        flag2 = isInterleave_r(s1, s2, s3, idx1, idx2 + 1, idx3 + 1);
    }
    return flag1 || flag2;
}

bool isInterleave(string s1, string s2, string s3) {
    if (s1.size() + s2.size() != s3.size()) {
        return false;
    }
    return isInterleave_r(s1, s2, s3, 0, 0, 0);
}
