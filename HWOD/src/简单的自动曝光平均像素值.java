import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 简单的自动曝光平均像素值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] imagesInts = Arrays.stream((line.split(" "))).mapToInt(m -> Integer.parseInt(m)).toArray();
        float maxSum = Arrays.stream((line.split(" "))).mapToInt(m -> Integer.parseInt(m)).sum();
        List<Integer> images = Arrays.stream((line.split(" "))).map(m -> Integer.parseInt(m)).collect(Collectors.toList());
        float currentAvg = maxSum / images.size();
        int k = 0;
        if (currentAvg == 128) {
            System.out.println(0);
        } else if (currentAvg < 128) {
            float min = 128 - currentAvg;
            while (min > 0) {
                k++;
                currentAvg = (maxSum + images.size() * k) / images.size();
                min = 128 - currentAvg;
            }
            float tmp = 128 - (maxSum + images.size() * (k + 1)) / images.size();
            if (tmp * -1 < min) {
                k++;
            }
            System.out.println(k);

        } else {
            float min = currentAvg - 128;
            while (min > 0) {
                k--;
                for (int i = 0; i < imagesInts.length; i++) {
                    if (imagesInts[i] - 1 <= 0) {
                        imagesInts[i] = 0;
                    } else {
                        imagesInts[i]--;
                    }
                }
                float currentMaxSum = Arrays.stream(imagesInts).sum();
                currentAvg = (currentMaxSum) / images.size();
                min = currentAvg - 128;
            }
            for (int i = 0; i < imagesInts.length; i++) {
                if (imagesInts[i] - 1 <= 0) {
                    imagesInts[i] = 0;
                } else {
                    imagesInts[i]--;
                }
            }
            float tmpMaxSum = Arrays.stream(imagesInts).sum();
            float tmp = tmpMaxSum / images.size();
            if (128 - (tmp * -1) < min) {
                k--;
            }
            System.out.println(k);
        }

    }
}
