import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 观看文艺汇演问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<YanChu> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt() + start + 15;
            list.add(new YanChu(start, end));
        }
        list.sort(Comparator.comparingInt(YanChu::getEndTime));
        int sum = 1;
        for (int i = 1; i < list.size(); i++) {
            int end= list.get(i-1).getEndTime();
            int start = list.get(i).getStartTime();
            if(start>end){
                sum++;
            }
        }
        System.out.println(sum);
    }

    static class YanChu {
        int startTime;
        int endTime;

        public YanChu(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }
}
