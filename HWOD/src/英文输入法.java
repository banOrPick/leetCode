import java.util.*;
import java.util.stream.Collectors;

public class 英文输入法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pre = scanner.nextLine();
        String[] split = input.split(",");
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] words = s.split(" ");
            for (int j = 0; j < words.length; j++) {
                if(words[j].contains("'")){
                    String[] strings = words[j].split("'");
                    for (int k = 0; k <strings.length; k++) {
                        wordList.add(strings[k]);
                    }
                }else{
                    wordList.add(words[j]);
                }

            }
        }
        Set<String> list = wordList.stream().filter(s ->
                s.length() >= pre.length()
        ).filter(s ->
                s.startsWith(pre)
        ).sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        if (list == null || list.size() == 0) {
            System.out.println(pre);
        } else {
            System.out.println(String.join(" ", list).trim());
        }

    }
}
