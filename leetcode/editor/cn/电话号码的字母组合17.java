import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 电话号码的字母组合17 {
    @Test

    public void test() {
        System.out.println(letterCombinations(""));
    }

    public HashMap<Integer, Character[]> map = new HashMap<>();
    public List<String> result = new ArrayList<>();
    public String resultString = "";

    public List<String> letterCombinations(String digits) {
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});
        if (digits.length() == 0) {
            return result;
        }
        dfs(0, digits);
        return result;


    }

    private void dfs(int index, String digits) {
        if (index == digits.length()) {
            result.add(resultString);
            return;
        }
        Integer key = Integer.parseInt(String.valueOf(digits.charAt(index)));
        Character[] characters = map.get(key);
        for (Character character : characters) {
            resultString = resultString + character;
            dfs(index + 1, digits);
            resultString = resultString.substring(0, resultString.length() - 1);
        }
    }
}
