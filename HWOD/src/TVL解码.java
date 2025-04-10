import java.util.Scanner;

/**
 * 题目描述
 * TLV编码是按[Tag Length Value]格式进行编码的，一段码流中的信元用Tag标识，Tag在码流中唯一不重复，Length表示信元Value的长度，Value表示信元的值。
 * <p>
 * 码流以某信元的Tag开头，Tag固定占一个字节，Length固定占两个字节，字节序为小端序。
 * <p>
 * 现给定TLV格式编码的码流，以及需要解码的信元Tag，请输出该信元的Value。
 * <p>
 * 输入码流的16进制字符中，不包括小写字母，且要求输出的16进制字符串中也不要包含小写字母；码流字符串的最大长度不超过50000个字节。
 * <p>
 * 输入描述
 * 输入的第一行为一个字符串，表示待解码信元的Tag；
 * <p>
 * 输入的第二行为一个字符串，表示待解码的16进制码流，字节之间用空格分隔。
 * <p>
 * 输出描述
 * 输出一个字符串，表示待解码信元以16进制表示的Value。
 * <p>
 * 示例1
 * 输入
 * <p>
 * 31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 输出
 * <p>
 * 32 33
 * <p>
 * 说明
 * <p>
 * 需要解析的信元的Tag是31，
 * 从码流的起始处开始匹配，
 * 第一个信元的Tag是32，信元长度为1（01 00，小端序表示为1）；
 * 第二个信元的Tag是90，其长度为2；
 * 第三个信元的Tag是30，其长度为3；
 * 第四个信元的Tag是31，其长度为2（02 00），
 * 所以返回长度后面的两个字节即可，即32 33。
 **/
public class TVL解码 {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String tag = scanner.nextLine();
//        String line = scanner.nextLine();
//        String[] split = line.split(" ");
//        int index=0;
//        while(index< split.length){
//            String tmpTag=split[index];
//            int length=Integer.parseInt(split[index+2]+split[index+1],16);
//            if(tag.equals(tmpTag)){
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i <length; i++) {
//                    sb.append(split[index+3+i]).append(" ");
//                }
//                System.out.println(sb.toString().toUpperCase().trim());
//                break;
//            }else{
//                index=index+3+length;
//            }
//
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入待解码信元的 Tag
        String tag = sc.nextLine();

        // 输入 16 进制码流
        String line = sc.nextLine();

        // 将 16 进制码流按空格分割成字符串数组
        String[] hexArray = line.split(" ");

        int index = 0;
        while (index < hexArray.length) {
            // 获取当前信元的长度
            int length = getCellLength(hexArray, index);

            // 如果当前信元的 Tag 与待解码信元的 Tag 相同
            if (hexArray[index].equals(tag)) {
                String value = getCellValue(hexArray, index, length);
                // 输出待解码信元的 Value，转换为大写并去除首尾空格
                System.out.println(value.toUpperCase().trim());
                break;
            } else {
                // 跳过当前信元
                index += (2 + length + 1);
            }
        }
    }

    // 获取当前信元的长度
    private static int getCellLength(String[] hexArray, int index) {
        return Integer.parseInt(hexArray[index + 2] + hexArray[index + 1], 16);
    }

    // 获取当前信元的 Value
    private static String getCellValue(String[] hexArray, int index, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = index + 3; i < index + 3 + length; i++) {
            sb.append(hexArray[i]).append(" ");
        }
        return sb.toString();
    }

}
/**
 * 完整用例
 * 用例1
 * 31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例2
 * 30
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例3
 * 33
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例4
 * 32
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例5
 * 31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00
 * <p>
 * <p>
 * 用例6
 * 31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例7
 * 30
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例8
 * 33
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例9
 * 32
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * <p>
 * <p>
 * 用例10
 * 31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 **/