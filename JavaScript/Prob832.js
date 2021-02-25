var flipAndInvertImage = function(A) {
    let row = A.length;
    let col = A[0].length;
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col / 2; j++) {
            console.log(i,j);
            // j and A[0].length - 1 - j
            if (j == col - 1 - j) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            } else {
                tmp = A[i][j];
                A[i][j] = A[i][col-1-j] == 1 ? 0 : 1;
                A[i][col-1-j] = tmp == 1 ? 0 : 1;
            }
            console.log(A[i]);
        }
    }
    return A;
};

flipAndInvertImage( [[1,1,0],[1,0,1],[0,0,0]]);