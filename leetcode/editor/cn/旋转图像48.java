public class 旋转图像48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < (n+1)/2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - j - 1][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
    }
}
