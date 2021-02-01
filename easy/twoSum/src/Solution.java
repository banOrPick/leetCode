/*
 * Project Name: leetCode
 * Class Name: PACKAGE_NAME.TwoSun
 * @date: 2021/2/1 11:06
 *
 * Copyright (C) 2019,suntang.com All Right Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * <br>
 * @date: 2021/2/1 11:06
 * @author: h00000042/huJinRui
 * @version: PoliceAnalysis V1.0
 * @since: JDK 1.8
 */
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>(8);
        for (int i = 0; i < nums.length; i++) {
            Integer result = target - nums[i];
            if (hashMap.containsKey(result)) {
                return new int[] {hashMap.get(result), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;

    }
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] twoSum = twoSum2(new int[] {3, 3}, 6);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
        }
    }
}
