import java.util.Scanner;

public class 环中最长子串字符成环找偶数O {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int oNum = getONum(line);
        int maxNum;
        if (oNum / 2 == 0) {
            maxNum = oNum;
        } else {
            maxNum = oNum - 1;
        }
        if(maxNum==0){
            System.out.println(line.length());
            return;
        }
        int n = line.length();
        StringBuffer newStr = new StringBuffer(line);
        int left = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            newStr.append(line.charAt(i));
        }
        for (int right = 0; right < newStr.length(); right++) {
            String tmpStr = newStr.substring(left, right);
            if (getONum(tmpStr) > maxNum) {
                left++;
            }
            if(getONum(tmpStr) == maxNum){
                max=Math.max(max,tmpStr.length());
            }
        }
        System.out.println(max);


    }

    static int getONum(String str) {
        int nums = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'o') {
                nums++;
            }
        }
        return nums;
    }
}
