/**
 * @param {number[]} nums
 */
var NumArray = function(nums) {
    const n = nums.length;
    this.arr  = new Array(n + 1).fill(0)
    for(let i = 0; i < n; i++) {
        this.arr[i+1] = this.arr[i] + nums[i];
    }
};

/** 
 * @param {number} i 
 * @param {number} j
 * @return {number}
 */
NumArray.prototype.sumRange = function(i, j) {
    return this.arr[j+1] - this.arr[i];
};

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */