public class 颜色分类75 {
//    public void sortColors(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] >= nums[j]) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//
//    }
    public void sortColors(int[] nums) {
        nums = quickSort(nums, 0, nums.length - 1);

    }
    //以左边的值作为基准值 双指针划分的方法
    public static int[] quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[left];
        int index = left;
        while (i < j) {
            while (i < j) {
                if (arr[j] < pivot) {
                    arr[i] = arr[j];
                    index = j;
                    i++;
                    break;
                }
                j--;
            }
            while (i < j) {
                if (arr[i] > pivot) {
                    arr[j] = arr[i];
                    index = i;
                    j--;
                    break;
                }
                i++;
            }
        }
        arr[index] = pivot;
        if (left <= index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (right >= index + 1) {
            quickSort(arr, index + 1, right);
        }
        return arr;
    }
}
