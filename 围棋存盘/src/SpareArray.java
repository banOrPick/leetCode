public class SpareArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] ints = new int[11][11];
        ints[1][2] = 1;
        ints[2][3] = 2;
        for (int[] row : ints) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数据 转 稀疏数组
        //1.先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (ints[i][j] != 0) {
                    sum++;
                }
            }
        }
    }
}
