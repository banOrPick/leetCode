import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));

    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if(list.isEmpty()){
                list.add(interval);
            }else{
                int[] ints = list.get(list.size() - 1);
                int tmpStart = interval[0], tmpEnd = interval[1];
                if(tmpStart <= ints[1]){
                    ints[1] = Math.max(tmpEnd, ints[1]);
                }else{
                    int[] newInterval = new int[]{tmpStart, tmpEnd};
                    list.add(newInterval);
                }
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
