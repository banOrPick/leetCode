import org.junit.Test;

public class 加油站134 {
    @Test
    public void hIndex() {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int current = 0;
            int startIndex = i;
            int endIndex = startIndex - 1 < 0 ? gas.length - 1 : startIndex - 1;
            while (startIndex != endIndex) {
                current = gas[startIndex] + current;
                if (current < cost[startIndex]) {
                    break;
                }
                current = current - cost[startIndex];
                startIndex = startIndex + 1;
                startIndex = startIndex > gas.length - 1 ? 0 : startIndex;

            }
            if (startIndex == endIndex && (current+gas[startIndex]) >= cost[startIndex]) {
                return i;
            }
        }
        return -1;
    }
}
