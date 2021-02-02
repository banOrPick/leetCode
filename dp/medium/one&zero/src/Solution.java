/*
 * Project Name: leetCode
 * Class Name: PACKAGE_NAME.TwoSun
 * @date: 2021/2/1 11:06
 *
 * Copyright (C) 2019,suntang.com All Right Reserved.
 */



/**
 * @description: 一和零
 * <br>
 * @date: 2021/2/1 11:06
 * @author: h00000042/huJinRui
 * @version: PoliceAnalysis V1.0
 * @since: JDK 1.8
 */
class Solution {


    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--){
                for (int ones = n; ones >= count[1]; ones--){
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];
    }
    public static int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }

    public static void main(String[] args) {
        int maxForm = findMaxForm(new String[] {"0001", "111001","10", "1", "0"}, 5, 3);
        System.out.println(maxForm);
    }
}
