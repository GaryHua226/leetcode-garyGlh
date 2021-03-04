/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    var res = new Array(num+1).fill(0);
    for (let i = 0; i < num+1; i++) {
        res[i] = countOnes(i);
    }
    return res;
};

function countOnes (x) {
    let cnt = 0;
    while (x > 0) {
        x = x & (x - 1);
        cnt++;
    }
    return cnt;
}