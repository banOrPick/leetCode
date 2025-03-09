import java.util.*;

public class 猜字谜 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        String[] split1 = input1.split(",");
        List<String> list1 = Arrays.asList(split1);
        String[] split = input2.split(",");
        List<String> list = Arrays.asList(split);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String string = list.get(i);
            for (int j = 0; j < list1.size(); j++) {
                String inputStr = list1.get(j);
                if(quchong(inputStr).equals(quchong(string))||paixu(inputStr).equals(paixu(string))){
                    result.add(string);
                    break;
                }
            }

        }
        System.out.println(String.join(",", result));
        scanner.close();
    }

    private static String quchong(String string) {
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < string.length(); i++) {
            set.add(string.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        set.forEach(result::append);
        return result.toString().trim();
    }

    private static String paixu(String string) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
        }
        list.sort(Character::compareTo);
        StringBuilder result = new StringBuilder();
        list.forEach(result::append);
        return result.toString().trim();
    }
}
