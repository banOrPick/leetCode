package doc;

import java.util.*;
import java.util.stream.Collectors;

public class 字母异位词分组49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{
                "eat","tea","tan","ate","nat","bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> list = Arrays.asList(strs);
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : list) {
            String key=getString(str);
            List<String> tmpList = map.get(key);
            if (tmpList==null||tmpList.isEmpty()) {
                tmpList=new ArrayList<>();
            }
            tmpList.add(str);
            map.put(key, tmpList);
        }
        List<List<String>> values = map.values().stream().collect(Collectors.toList());
        return values;
    }

    private static String getString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
