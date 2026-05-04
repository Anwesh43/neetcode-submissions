class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int result[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m -1 - i] = matrix[i][j]; 
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(result[i][j]);
                matrix[i][j] = result[i][j];
            }
        }
    }
}

// 00 01 02 03
// 10 11 12 13
// 20 21 22 23

// 20 10 20
// 21 11 21
// 22 12 22
// 23 13 23

// 20  10   00
// 21  11   01
// 22  12   02
//    02