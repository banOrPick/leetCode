import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 数大雁 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入的字符串
        String chars = scanner.nextLine();
        // 定义标准的大雁叫声顺序
        String quack = "quack";
        // 定义一个状态数组，用于跟踪每个字符的出现次数
        int[] states = new int[quack.length()];
        // 记录同时发出叫声的大雁的最大数量
        int max_ = 0;

        // 遍历输入字符串中的每一个字符
        for (int i = 0; i < chars.length(); i++) {
            // 获取当前字符在"quack"中的索引
            int index = quack.indexOf(chars.charAt(i));
            // 如果索引为-1，表示输入的字符串包含非法字符，输出-1并退出程序
            if (index == -1) {
                System.out.println(-1);
                return;
            }

            if (index == 0) {
                // 如果是“q”，表示一个新的大雁叫声的开始
                states[index]++;
            } else {
                // 检查前一个字符的状态
                if (states[index - 1] == 0) {
                    // 如果前一个字符的状态为 0，说明顺序不符合要求，输出-1并退出程序
                    System.out.println(-1);
                    return;
                }
                // 前一个字符的状态减 1
                states[index - 1]--;
                // 当前字符的状态加 1
                states[index]++;
            }

            // 计算当前正在叫的大雁数量
            int currentGeese = 0;
            for (int j = 0; j < states.length; j++) {
                currentGeese += states[j];
            }
            // 更新最大大雁数量
            max_ = Math.max(max_, currentGeese);

            if (index == quack.length() - 1) {
                // 如果当前字符是“k”，表示一个完整的“quack”叫声已经结束
                states[index]--;
            }
        }

        // 检查状态数组中是否还有未完成的叫声
        for (int i = 0; i < states.length - 1; i++) {
            if (states[i] != 0) {
                // 如果有未完成的叫声，输出-1
                System.out.println(-1);
                return;
            }
        }

        // 输出最大的大雁数量
        System.out.println(max_);
        scanner.close();
    }
//        Scanner sc = new Scanner(System.in);
//        String[] input = sc.nextLine().split("");
//        String string = "quack";
//        int count = 0;
//        for (int i = 0; i < input.length; i++) {
//            if (input[i].equals("q")) {
//                for (int j = i + 1; j < input.length; j++) {
//                    if (input[j].equals("u")) {
//                        for (int k = j + 1; k < input.length; k++) {
//                            if (input[k].equals("a")) {
//                                for (int l = k + 1; l < input.length; l++) {
//                                    if (input[l].equals("c")) {
//                                        for (int m = l + 1; m < input.length; m++) {
//                                            if (input[m].equals("k")) {
//                                                count++;
//                                                input[i] = String.valueOf(count);
//                                                input[j] = String.valueOf(count);
//                                                input[k] = String.valueOf(count);
//                                                input[l] = String.valueOf(count);
//                                                input[m] = String.valueOf(count);
//                                                break;
//                                            }
//                                        }
//                                        break;
//                                    }
//
//                                }
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        int result=0;
//        for (int i = 0; i < ; i++) {
//
//        }
//        if (count == 0) {
//            System.out.println(-1);
//        } else {
//            System.out.println(count);
//        }
//        sc.close();
//    }
}
