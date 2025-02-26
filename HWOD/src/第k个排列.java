import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 第k个排列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<String> numList = new ArrayList<>();
        LinkedList<Integer> resultList = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            numList.add(String.valueOf(i));
        }
        process(numList,"",resultList);
        Collections.sort(resultList);
        System.out.println(resultList.get(k-1));

    }
    static void process( List<String> numList,String current,LinkedList<Integer> resultList){
        if(numList.size()==0){
            resultList.add(Integer.parseInt(current));
        }
        for (int i = 0; i <numList.size(); i++) {
            String num=numList.get(i);
            List<String> newNum=new ArrayList<>();
            for (int j = 0; j < i; j++) {
                newNum.add(numList.get(j));
            }
            for (int j = i+1; j < numList.size(); j++) {
                newNum.add(j-1,numList.get(j));
            }
            process(newNum,current+num,resultList);
        }
    }
}
