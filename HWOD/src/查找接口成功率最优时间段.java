import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class 查找接口成功率最优时间段 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minAverageLost = Integer.parseInt(scanner.nextLine());
        String nums = scanner.nextLine();
        Set<String> resultSet = new TreeSet<>();
        List<Integer> numsList = Arrays.stream(nums.split(" ")).map(str -> Integer.parseInt(str
        )).collect(Collectors.toList());
        int sumRight = 0;
        int sumLeft = numsList.get(0);
        int left = 0;
        int maxNum = 0;
        for (int right = 0; right < numsList.size(); right++) {
            sumRight += numsList.get(right);
            while (sumRight - sumLeft + numsList.get(left) > minAverageLost * (right - left + 1)&& right!=left) {
                left++;
                sumLeft += numsList.get(left);
            }
            if (right - left + 1 == maxNum && resultSet.size() != 0&& (sumRight - sumLeft + numsList.get(left) <= minAverageLost * (right - left + 1))) {
                StringBuffer result = new StringBuffer();
                result.append(left).append("-").append(right);
                resultSet.add(result.toString());
            }
            if (right - left + 1 > maxNum && (sumRight - sumLeft + numsList.get(left) <= minAverageLost * (right - left + 1))) {
                maxNum = right - left + 1;
                StringBuffer result = new StringBuffer();
                result.append(left).append("-").append(right);
                resultSet.clear();
                resultSet.add(result.toString());
            }
        }
        if(resultSet.size()==0){
            System.out.println("NULL");
        }else{
            StringBuffer resultString = new StringBuffer();
            resultSet.stream().forEach(str -> resultString.append(str).append(" "));
            System.out.println(resultString.toString().trim());
        }

    }
}
