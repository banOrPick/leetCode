import java.util.Scanner;

/**
 * 最新华为OD机试
 * 题目描述
 * 存在一种虚拟IPv4地址，由4小节组成，每节的范围为0~255，以#号间隔，虚拟IPv4地址可以转换为一个32位的整数，例如：
 * <p>
 * 128#0#255#255，转换为32位整数的结果为2147549183（0x8000FFFF）
 * <p>
 * 1#0#0#0，转换为32位整数的结果为16777216（0x01000000）
 * <p>
 * 现以字符串形式给出一个虚拟IPv4地址，限制第1小节的范围为1128，即每一节范围分别为(1128)#(0255)#(0255)#(0~255)，要求每个IPv4地址只能对应到唯一的整数上。如果是非法IPv4，返回invalid IP
 * <p>
 * 输入描述
 * 输入一行，虚拟IPv4地址格式字符串
 * <p>
 * 输出描述
 * 输出一行，按照要求输出整型或者特定字符
 * <p>
 * 示例1
 * 输入
 * <p>
 * 100#101#1#5
 * 1
 * 输出
 * <p>
 * 1684340997
 * 1
 * 说明
 * <p>
 * 示例2
 * 输入
 * <p>
 * 1#2#3
 * 1
 * 输出
 * <p>
 * invalid IP
 * 1
 * 说明
 * <p>
 * 解题思路
 * 虚拟IPv4地址由四个小节组成，每个小节用#号分隔。在这个虚拟版本中用#替代。每个小节代表一个整数，范围从0到255，但题目中特别指出第一小节的范围应为1到128。地址的正确形式应该是四部分，例如 1#2#3#4。如果格式不正确或数值不在指定范围内，则视为非法IPv4，输出“invalid IP”。
 **/
class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String ipv4 = sc.nextLine();
//        String[] strings = ipv4.split("#");
//        if (strings.length != 4) {
//            System.out.println("invalid IP");
//            return;
//        }
//        for (String string : strings) {
//            if (!isNumeric(string)) {
//                System.out.println("invalid IP");
//                return;
//            }
//            if (Integer.parseInt(string) > 255 || Integer.parseInt(string) < 0) {
//                System.out.println("invalid IP");
//                return;
//            }
//        }
//        long result=0;
//        for (int i = 0; i < 4; i++) {
//            result=result*256+Integer.parseInt(strings[i]);
//        }
//        System.out.println(result);
//
//    }
//
//    public static Boolean isNumeric(String str) {
//        for (int i = 0; i < str.length(); i++) {
//            if (!Character.isDigit(str.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] ipSections = input.split("#");

        if (!isValidIPFormat(ipSections)) {
            System.out.println("invalid IP");
            return;
        }

        long ipValue = convertIPToLong(ipSections);
        System.out.println(ipValue);
    }

    // 检查IP地址格式是否有效
    private static boolean isValidIPFormat(String[] ipSections) {
        if (ipSections.length != 4) {
            return false;
        }

        for (String section : ipSections) {
            if (!isValidSection(section)) {
                return false;
            }
        }

        int firstSection = Integer.parseInt(ipSections[0]);
        return firstSection >= 1 && firstSection <= 128;
    }

    // 检查单个IP节是否有效
    private static boolean isValidSection(String section) {
        if (!isNumeric(section) || section.length() == 0) {
            return false;
        }
        if (section.length() > 1 && section.charAt(0) == '0') {
            return false;
        }
        int sectionValue = Integer.parseInt(section);
        return sectionValue >= 0 && sectionValue <= 255;
    }

    // 将有效的IP地址转换为长整型
    private static long convertIPToLong(String[] ipSections) {
        long ipValue = 0;
        for (String section : ipSections) {
            ipValue = ipValue * 256 + Integer.parseInt(section);
        }
        return ipValue;
    }

    // 判断字符串是否为数字
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}