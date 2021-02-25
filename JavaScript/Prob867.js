/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var transpose = function(matrix) {
    // my code
    // res = [];
    // for (let row = 0; row < matrix[0].length; row++) {
    //     res[row] = [];
    // }
    // for (let row = 0; row < matrix.length; row++) {
    //     for (let col = 0; col < matrix[0].length; col++) {
    //         res[col].push(matrix[row][col]);
    //     }
    // }
    // return res;

    // official answer
    const m = matrix.length, n = matrix[0].length;
    const transposed = new Array(n).fill(0).map(() => new Array(m).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            transposed[i][j] = matrix[j][i];
        }
    }
    return transposed;
}


transpose([[1,2,3],[4,5,6],[7,8,9]])