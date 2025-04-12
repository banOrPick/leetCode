import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class 下一个排列31 {
    @Test
    public void test() {
        nextPermutation(new int[]{1, 1, 5});
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
//    public void nextPermutation(int[] nums) {
//        List<List<Integer>> list = permute(nums);
//        Set<List<Integer>> permute = new LinkedHashSet<>(list);
//        List<Integer> result = new ArrayList<>();
//        permute = permute.stream().sorted((o1, o2) -> {
//            for (int i = 0; i < o1.size(); i++) {
//                int cmp = o1.get(i).compareTo(o2.get(i));
//                if (cmp != 0) {
//                    return cmp;
//                }
//            }
//            return Integer.compare(o1.size(), o2.size());
//        }).collect(Collectors.toCollection(LinkedHashSet::new));
//        boolean flag = true;
//        int i = 0;
//        Iterator<List<Integer>> iterator = permute.iterator();
//        while (iterator.hasNext() && flag) {
//            List<Integer> l = iterator.next();
//            for (int j = 0; j < l.size(); j++) {
//                if (l.get(j) != nums[j]) {
//                    break;
//                }
//                if (j == l.size() - 1) {
//                    if (i == permute.size() - 1) {
//                        result = permute.stream().findFirst().get();
//                    } else {
//                        result = iterator.next();
//                    }
//                    flag = false;
//
//                }
//            }
//            i++;
//        }
//        for (int j = 0; j < result.size(); j++) {
//            nums[j] = result.get(j);
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int dept = 0;
        dfs(visited, nums, resultList, result, dept);
        return resultList;
    }

    public void dfs(boolean[] visited, int[] nums, List<List<Integer>> resultList, List<Integer> result, int dept) {
        if (dept == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result.add(nums[i]);
            dfs(visited, nums, resultList, result, dept + 1);
            visited[i] = false;
            result.remove(result.size() - 1);
        }
    }
}
