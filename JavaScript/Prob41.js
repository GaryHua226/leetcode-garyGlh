/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    nums.push(-2);
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            nums[i] = -2;
        }
    }
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            continue;
        }
        tmp = nums[i];
        while (tmp >= 0 && tmp < nums.length) {
            next = nums[tmp];
            nums[tmp] = -1;
            tmp = next;
        }
    }
    for (let i = 1;i < nums.length; i++) {
        if (nums[i] != -1) {
            return i;
        }
    }
    return Math.max(nums.length,1);
};

console.log(firstMissingPositive([2147483647]));