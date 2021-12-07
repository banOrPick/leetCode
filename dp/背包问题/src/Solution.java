/*
 * Project Name: leetCode
 * Class Name: PACKAGE_NAME.Solution
 * @date: 2021/2/2 14:26
 *
 * Copyright (C) 2019,suntang.com All Right Reserved.
 */

/**
 * @description: 背包问题
 * <br>
 * @date: 2021/2/2 14:26
 * @author: h00000042/huJinRui
 * @version: PoliceAnalysis V1.0
 * @since: JDK 1.8
 */
public class Solution {
    public static void main(String[] args) {
        //物品的重量
        int[] w = {1, 4, 3};
        //物品价值
        int[] val = {1500, 3000, 2000};
        //背包容量
        int m = 4;
        //物品的个数
        int n = val.length;
        int[][] v = new int[n + 1][m + 1];
        //初始化第一行和第一列，这里在本程序中，可以不去处理，因为默认就是0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                }
                else {
                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }
}
