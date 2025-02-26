import java.util.ArrayList;
import java.util.Scanner;

public class 最长方连续方波信号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String minStr="01";
        StringBuffer maxResult = new StringBuffer();
        int maxLength=0;
        int left=0;
        for (int right = 0; right < input.length(); right++) {
            int tmpright = Integer.parseInt(String.valueOf(input.charAt(right)));
            if(tmpright==1||right==left||right-left<3){
                continue;
            }
            boolean flag=true;
            String substring = input.substring(left, right+1);
            StringBuffer tmpStr = new StringBuffer();

            for (int i = 1; i <= (right-left)/2; i++) {
                tmpStr.append(minStr);
            }
            tmpStr.append("0");
            while(!substring.equals(tmpStr.toString())&&left < input.length()&&left < right){
                left++;
                substring = input.substring(left, right+1);
            }
            if(maxLength<right-left&&right-left>=2){
                if(right==input.length()-1){
                    maxLength=right-left;
                    maxResult=tmpStr;
                }else if(Integer.parseInt(String.valueOf(input.charAt(right+1)))==0){
                    maxLength=right-left;
                    maxResult=tmpStr;
                }

            }
        }
        System.out.println(maxResult.toString());

    }
}
