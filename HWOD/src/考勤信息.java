import java.util.Scanner;

public class 考勤信息 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String inputString = scanner.nextLine();
            boolean result = process(inputString);
            buffer.append(String.valueOf(result)).append(" ");
        }
        System.out.println(buffer.toString().trim());
    }

    private static boolean process(String inputString) {
        boolean result = true;
        String[] s = inputString.split(" ");
        int absent = 0;
        for (int i = 0; i < s.length; i++) {
            if ("absent".equals(s[i])) {
                absent++;
            }
            if (absent > 1) {
                result = false;
                return result;
            }
            if (("late".equals(s[i]) || "leaveearly".equals(s[i])) && i + 1 < s.length) {
                if ("late".equals(s[i + 1]) || "leaveearly".equals(s[i + 1])) {
                    result = false;
                    return result;
                }
            }
            if (i + 7 < s.length) {
                int presents = 0;
                for (int j = i; j < 7; j++) {
                    if ("present".equals(s[j])) {
                        presents++;
                    }
                    if (presents >= 3) {
                        result = false;
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
