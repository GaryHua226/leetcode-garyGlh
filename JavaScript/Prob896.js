/**
 * @param {number[]} A
 * @return {boolean}
 */
var isMonotonic = function(A) {
    var start = 0;
    while (start < A.length - 1) {
        if (A[start] == A[start+1]) {
            start++;
        } else {
            break;
        }
    }
    if (start == A.length - 2) {
        return true;
    }
    var flag = A[start] > A[start + 1];
    for (start++; start < A.length - 1; start++) {
        if (A[start] == A[start+1]) {
            continue;
        } else if (A[start] > A[start+1] == flag) {
            continue;
        } else {
            return false;
        }
    }
    return true;
};

console.log(isMonotonic([4,4,4,3,5,3,2]));