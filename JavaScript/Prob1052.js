var maxSatisfied = function(customers, grumpy, X) {
    if (X >= customers.length) {
        let res = 0;
        for (let i of customers) {
            res += i;
        }
        return res;
    }
    let ori = 0; // 原本就不生气得到的
    for (let i = 0; i < customers.length; i++) {
        if (grumpy[i] != 0) {
            ori += customers[i];
        }
    }
    let add = 0; // 通过用X抑制得到的
    let temp = 0;
    let i = 0, j = i + X;
    for (let k = i; k < j; k++) {
        if (grumpy[k] == 0) {
            add += customers[k];
        }
    }
    temp = add;
    while (j < customers.length) {
        if (grumpy[i] == 0) {
            temp -= customers[i];
        }
        i++;
        if (grumpy[j] == 0) {
            temp += customers[j];
        }
        j++;
        if (temp > add) {
            add = temp;
        }
    }
    return ori + add;
};

var res = maxSatisfied([4,10,10], [1,1,0], 2);
console.log(res);