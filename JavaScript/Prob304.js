/**
 * @param {number[][]} matrix
 */
var NumMatrix = function(matrix) {
    const row = matrix.length;
    const col = matrix[0].length;
    // create a matrix
    this.arr = new Array(row);
    for (let i = 0; i < row; i++) {
        this.arr[i] = new Array(col).fill(0);
    }
    // fill in the values
    this.arr[0][0] = matrix[0][0];
    for (let i = 1; i < col; i++) {
        this.arr[0][i] = this.arr[0][i-1] + matrix[0][i];
    }
    for (let i = 1; i < row; i++) {
        this.arr[i][0] = this.arr[i-1][0] + matrix[i][0];
    }
    for (let i = 1; i < row; i++) {
        for (let j = 1; j < col; j++) {
            this.arr[i][j] = this.arr[i-1][j] + this.arr[i][j-1] - this.arr[i-1][j-1] + matrix[i][j];
        }
    }    
};

/** 
 * @param {number} row1 
 * @param {number} col1 
 * @param {number} row2 
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {
    if (row1 !== 0 && col1 !== 0) {
        return this.arr[row2][col2] - this.arr[row2][col1-1] + this.arr[row1-1][col1-1] - this.arr[row1-1][col2];
    } else if (row1 === 0 && col1 === 0) {
        return this.arr[row2][col2];
    } else if (row1 === 0) {
        return this.arr[row2][col2] - this.arr[row2][col1-1];
    } else if (col1 === 0) {
        return this.arr[row2][col2] - this.arr[row1-1][col2];
    }
    
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */

 var mat = new NumMatrix([[3, 0, 1, 4, 2],
                          [5, 6, 3, 2, 1],
                          [1, 2, 0, 1, 5],
                          [4, 1, 0, 1, 7],
                          [1, 0, 3, 0, 5]])
 console.log(mat)
 console.log(mat.sumRegion(0,0,4,4))