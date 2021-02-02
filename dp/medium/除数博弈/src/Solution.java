/*
 * Project Name: leetCode
 * Class Name: PACKAGE_NAME.Solution
 * @date: 2021/2/2 10:40
 *
 * Copyright (C) 2019,suntang.com All Right Reserved.
 */

/**
 * @description: 除数博弈
 * <br>
 * @date: 2021/2/2 10:40
 * @author: h00000042/huJinRui
 * @version: PoliceAnalysis V1.0
 * @since: JDK 1.8
 */
public class Solution {
    public boolean divisorGame(int N) {
        int result = 1;
        int x = 1;
        while (N > 0 && N % x == 0) {
            N = N - x;
            result++;
        }
        if (result % 2 == 1) {
            return true;
        }
        return false;
    }
}
