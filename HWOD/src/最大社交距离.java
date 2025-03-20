import java.util.*;

public class 最大社交距离 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seatNum = Integer.parseInt(scanner.nextLine());
        // 去除字符串首尾的括号并分割成数组
        String str = scanner.nextLine();
        String[] operationsStr = str.substring(1, str.length() - 1).split(",");
        List<Integer> operations = new ArrayList<>();
        for (String s : operationsStr) {
            operations.add(Integer.parseInt(s.trim()));
        }

        TreeSet<Integer> occupied = new TreeSet<>();
        int lastEntrantPos = -1;

        for (int op : operations) {
            if (op == 1) {
                if (occupied.size() == seatNum) {
                    lastEntrantPos = -1;
                    continue;
                }
                if (occupied.isEmpty()) {
                    occupied.add(0);
                    lastEntrantPos = 0;
                } else {
                    List<int[]> candidates = new ArrayList<>();

                    // 处理左边间隙
                    int first = occupied.first();
                    if (first > 0) {
                        int distance = first;
                        candidates.add(new int[]{distance, 0});
                    }

                    // 处理中间间隙
                    Integer prev = null;
                    for (int current : occupied) {
                        if (prev != null) {
                            int gap = current - prev - 1;
                            if (gap > 0) {
                                int distance = (gap + 1) / 2; // 最大可能距离
                                int pos = prev + distance;
                                candidates.add(new int[]{distance, pos});
                            }
                        }
                        prev = current;
                    }

                    // 处理右边间隙
                    int last = occupied.last();
                    if (last < seatNum - 1) {
                        int distance = (seatNum - 1 - last);
                        candidates.add(new int[]{distance, seatNum - 1});
                    }

                    // 选择最佳位置
                    int maxDistance = -1;
                    int bestPos = -1;
                    for (int[] candidate : candidates) {
                        int distance = candidate[0];
                        int pos = candidate[1];
                        if (distance > maxDistance) {
                            maxDistance = distance;
                            bestPos = pos;
                        } else if (distance == maxDistance) {
                            if (pos < bestPos) {
                                bestPos = pos;
                            }
                        }
                    }

                    occupied.add(bestPos);
                    lastEntrantPos = bestPos;
                }
            } else {
                // 处理离场操作
                int pos = Math.abs(op);
                occupied.remove(pos);
            }
        }

        System.out.println(lastEntrantPos);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 读取输入
//        int seatNum = scanner.nextInt();  // 读取座位总数
//        scanner.nextLine();  // 读取换行符
//        String str = scanner.nextLine();  // 读取座位占用和离开的操作序列
//        // 去除字符串首尾的括号并分割成数组
//        String[] parts = str.substring(1, str.length() - 1).split(",");
//        ArrayList<Integer> seatOrLeave = new ArrayList<>();
//        for (String part : parts) {
//            seatOrLeave.add(Integer.parseInt(part.trim()));  // 转换为整数并添加到列表
//        }
//
//        // 初始化
//        ArrayList<Integer> seat = new ArrayList<>();  // 存储已占用的座位
//        int ans = -1;  // 下一个人的最佳座位号
//
//        // 遍历座位占用和离开的操作序列
//        for (int sol : seatOrLeave) {
//            if (sol != 1) {
//                // 如果sol为负数，表示有员工离开，移除对应座位号
//                seat.remove(Integer.valueOf(-sol));
//            } else {
//                // 如果sol为1，表示有员工进入，需要找到最佳座位
//                if (seat.isEmpty()) {
//                    // 如果会议室为空，新员工坐在0号座位
//                    ans = 0;
//                } else {
//                    // 如果会议室不为空，找到最大的空闲区间
//                    int maxDistance = seat.get(0);  // 初始化最大距离为第一个座位号
//                    ans = 0;  // 初始化最佳座位号为0
//                    for (int i = 0; i < seat.size(); i++) {
//                        int distance;
//                        if (i == seat.size() - 1) {
//                            // 检查最后一个座位到座位总数之间的距离
//                            distance = seatNum - 1 - seat.get(i);
//                        } else {
//                            // 检查相邻座位之间的距离
//                            distance = (seat.get(i + 1) - seat.get(i)) / 2;
//                        }
//                        if (distance > maxDistance) {
//                            // 更新最大距离和最佳座位号
//                            maxDistance = distance;
//                            ans = (i == seat.size() - 1) ? seatNum - 1 : seat.get(i) + distance;
//                        }
//                    }
//                }
//
//                // 如果会议室已满，设置最佳座位号为-1
//                if (seat.size() == seatNum) {
//                    ans = -1;
//                } else {
//                    // 将新员工的座位号加入到座位列表，并排序
//                    seat.add(ans);
//                    Collections.sort(seat);
//                }
//            }
//        }
//
//        // 打印最后一个操作后的最佳座位号
//        System.out.println(ans);
//        scanner.close();
//    }
}
