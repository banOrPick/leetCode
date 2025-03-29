import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class 划分字母区间763 {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    }

    public static List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        int[] ints = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            ints[charArray[i] - 'a'] = Math.max(i, ints[charArray[i] - 'a']);
        }
        List<Integer> list = new ArrayList<>();
        int start = 0,end = 0;
        for (int i = 0; i < charArray.length; i++) {
            char ch=charArray[i];
            end = Math.max(end, ints[ch- 'a']);
            if (end == i) {
                list.add(end - start+1);
                start = end+1;
            }
        }
        return list;
    }
}
