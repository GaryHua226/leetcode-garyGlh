#include <iostream>

using namespace std;

string convertToTitle(int columnNumber) {
	string res;
	while (columnNumber > 0) {
		columnNumber--;
		res = char('A' + columnNumber % 26) + res;
		columnNumber /= 26;
	}
	return res;
}