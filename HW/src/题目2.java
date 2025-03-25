import java.util.List;
import java.util.Scanner;

public class 题目2 {
    public static String input1;
    public static String input2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input1 = sc.nextLine();
        input2 = sc.nextLine();
        char[] charArray1 = input1.toCharArray();

        int count = 0;
        boolean flag = true;
        int[] ints = new int[input2.length()];
        char[] charArray2 = input2.toCharArray();
        while (flag) {
            flag = getStart(charArray1,charArray2, flag, ints);
            if (flag) {
                for (int i = 0; i < ints.length; i++) {
                    charArray1[ints[i]] = '-';
                    input1 = new String(charArray1);
                }
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    private static boolean getStart(char[] charArray1,char[] charArray2, boolean flag, int[] ints) {
        for (int i = 0; i < input2.length(); i++) {
            int pos=-1;
            int j=0;
            if(i==0){
                j=0;
            }else{
                j=ints[i - 1];
            }
            for (; j < charArray1.length; j++) {
                if(charArray2[i]==charArray1[j]){
                    pos=j;
                    break;
                }
            }
            if (pos != -1) {
                ints[i] = pos;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
