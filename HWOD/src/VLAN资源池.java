import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * VLAN是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094之间的整数)的概念。
 * <p>
 * 定义一个VLAN ID的资源池(下称VLAN资源池)，资源池中连续的VLAN用开始VLAN-结束VLAN表示，不连续的用单个整数表示，所有的VLAN用英文逗号连接起来。
 * <p>
 * 现在有一个VLAN资源池，业务需要从资源池中申请一个VLAN，需要你输出从VLAN资源池中移除申请的VLAN后的资源池。
 * <p>
 * 输入描述
 * 第一行为字符串格式的VLAN资源池，第二行为业务要申请的VLAN，VLAN的取值范围为[1,4094]之间的整数。
 * <p>
 * 输出描述
 * 从输入VLAN资源池中移除申请的VLAN后字符串格式的VLAN资源池，输出要求满足题目描述中的格式，并且按照VLAN从小到大升序输出。
 * 如果申请的VLAN不在原VLAN资源池内，输出原VLAN资源池升序排序后的字符串即可。
 * <p>
 * 示例1
 * 输入
 * <p>
 * 1-5
 * 2
 * <p>
 * <p>
 * 输出
 * <p>
 * 1,3-5
 * <p>
 * 说明
 * <p>
 * 原VLAN资源池中有VLAN 1、2、3、4、5，从资源池中移除2后，剩下VLAN 1、3、4、5，按照题目描述格式并升序后的结果为1,3-5
 * <p>
 * 示例2
 * 输入
 * <p>
 * 20-21,15,18,30,5-10
 * 15
 * <p>
 * <p>
 * 输出
 * <p>
 * 5-10,18,20-21,30
 * <p>
 * 说明
 * <p>
 * 原VLAN资源池中有VLAN 5、6、7、8、9、10、15、18、20、21、30，从资源池中移除15后，资源池中剩下的VLAN为 5、6、7、8、9、10、18、20、21、30，按照题目描述格式并升序后的结果为5-10,18,20-21,30。
 * <p>
 * 示例3
 * 输入
 * <p>
 * 5,1-3
 * 10
 * <p>
 * <p>
 * 输出
 * <p>
 * 1-3,5
 * <p>
 * 说明
 * <p>
 * 原VLAN资源池中有VLAN 1、2、3，5，申请的VLAN 10不在原资源池中，将原资源池按照题目描述格式并按升序排序后输出的结果为1-3,5。
 **/
public class VLAN资源池 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vlanPool = scanner.nextLine();
        int vlan = scanner.nextInt();
        String[] vlanPoolList = vlanPool.split(",");
        List<String> collect = Arrays.stream(vlanPoolList).sorted((a, b) -> {
                    int aResult = 0;
                    int bResult = 0;
                    if (a.contains("-")) {
                        aResult = Integer.parseInt(a.split("-")[0]);
                    } else {
                        aResult = Integer.parseInt(a);
                    }
                    if (b.contains("-")) {
                        bResult = Integer.parseInt(b.split("-")[0]);
                    } else {
                        bResult = Integer.parseInt(b);
                    }
                    return aResult - bResult;
                }

        ).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            String t = collect.get(i);
            if (t.contains("-")) {
                int first = Integer.parseInt(t.split("-")[0]);
                int last = Integer.parseInt(t.split("-")[1]);
                if (vlan <= last && vlan >= first) {
                    collect.remove(i);
                    if (first == vlan - 1) {
                        collect.add(String.valueOf(first));
                    } else {
                        StringBuffer firstString = new StringBuffer();
                        firstString.append(first).append("-").append(vlan - 1);
                        collect.add(firstString.toString());
                    }
                    if (last == vlan + 1) {
                        collect.add(String.valueOf(last));
                    } else {
                        StringBuffer lastString = new StringBuffer();
                        lastString.append(vlan + 1).append("-").append(last);
                        collect.add(lastString.toString());

                    }
                    break;
                }
            }else{
                collect.remove(i);
            }
        }
        StringBuffer result = new StringBuffer();
        collect.stream().forEach(s -> {
            result.append(s).append(",");
        });
        System.out.println(result.toString().trim());

    }
}
