import java.util.Arrays;
import java.util.Random;

public class 快速排序 {

    public static void main(String[] args) {
        int[] ints = {3, 6, 8, 10, 1, 2, 3};
        int[] arr = quickSort(ints, 0, ints.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    //以左边的值作为基准值
//    public static int[] quickSort(int[] arr, int left, int right) {
//        int index = left+1;
//        if (left < right) {
//            int pivot = arr[left];
//            for (int i = index; i <= right; i++) {
//                if (arr[i] < pivot) {
//                    int temp = arr[i];
//                    arr[i] = arr[index];
//                    arr[index] = temp;
//                    index++;
//                }
//            }
//            int temp = arr[index-1];
//            arr[index-1] = pivot;
//            arr[left] = temp;
//            quickSort(arr, left, index - 2);
//            quickSort(arr, index, right);
//        }
//        return arr;
//    }

    //    以右的值作为基准值
//    public static int[] quickSort(int[] arr, int left, int right) {
//        int index = left;
//        if (left < right) {
//            int pivot = arr[right];
//            for (int i = index; i <= right - 1; i++) {
//                if (arr[i] < pivot) {
//                    int temp = arr[i];
//                    arr[i] = arr[index];
//                    arr[index] = temp;
//                    index++;
//                }
//            }
//            int temp = arr[index];
//            arr[index] = pivot;
//            arr[right] = temp;
//            quickSort(arr, left, index - 1);
//            quickSort(arr, index + 1, right);
//        }
//        return arr;
//    }


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
