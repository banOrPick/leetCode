public class 最后一个单词的长度58 {
    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }
}
