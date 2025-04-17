import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class H指数274 {
    @Test
    public void test() {
        hIndex(new int[]{0, 0});
    }

    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            return Math.min(citations[0], 1);
        }
        Arrays.sort(citations);
        int max = citations.length;
        for (int i = max; i > 0; i--) {
            if (citations[max - i] >= i) {
                return i;
            }
        }
        return 0;
    }
}
