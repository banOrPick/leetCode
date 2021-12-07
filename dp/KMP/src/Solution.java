/*
 * Project Name: leetCode
 * Class Name: PACKAGE_NAME.Solution
 * @date: 2021/2/2 15:06
 *
 * Copyright (C) 2019,suntang.com All Right Reserved.
 */

/**
 * @description: // TODO
 * <br>
 * @date: 2021/2/2 15:06
 * @author: h00000042/huJinRui
 * @version: PoliceAnalysis V1.0
 * @since: JDK 1.8
 */
public class Solution {

    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int match = violenceMatch(str1, str2);
        System.out.println(match);
    }

    public static int kmpMatch(String str1, String str2){

        return -1;
    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int size1 = str1.toCharArray().length;
        int size2 = str2.toCharArray().length;
        int i = 0;
        int j = 0;
        while (i < size1 && j < size2) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            }
            else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == size2) {
            return i - j;
        }
        return -1;
    }
}
