import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
题目描述
总共有 n 个人在机房，每个人有一个标号（1<=标号<=n），他们分成了多个团队，需要你根据收到的 m 条消息判定指定的两个人是否在一个团队中，具体的：

1、消息构成为 a b c，整数 a、b 分别代表两个人的标号，整数 c 代表指令
2、c == 0 代表 a 和 b 在一个团队内
3、c == 1 代表需要判定 a 和 b 的关系，如果 a 和 b 是一个团队，输出一行’we are a team’,如果不是，输出一行’we are not a team’
4、c 为其他值，或当前行 a 或 b 超出 1~n 的范围，输出‘da pian zi’
输入描述
1、第一行包含两个整数 n，m(1<=n,m<100000),分别表示有 n 个人和 m 条消息
2、随后的 m 行，每行一条消息，消息格式为：a b c(1<=a,b<=n,0<=c<=1)
输出描述
1、c ==1,根据 a 和 b 是否在一个团队中输出一行字符串，在一个团队中输出‘we are a team‘,不在一个团队中输出’we are not a team’
2、c 为其他值，或当前行 a 或 b 的标号小于 1 或者大于 n 时，输出字符串‘da pian zi‘
3、如果第一行 n 和 m 的值超出约定的范围时，输出字符串”Null“。
示例1
输入

5 7
1 2 0
4 5 0
2 3 0
1 2 1
2 3 1
4 5 1
1 5 1

输出

We are a team
We are a team
We are a team
We are not a team

说明

示例2
输入

5 6
1 2 0
1 2 1
1 5 0
2 3 1
2 5 1
1 3 2
输出
we are a team
we are not a team
we are a team
da pian zi
 */
public class 根据消息判断a和b是否在同一个队伍 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nm = scanner.nextLine();
        String[] input = nm.split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        if (n < 1 || m >= 100000) {
            System.out.println("Null");
        }
        ArrayList<Set<Integer>> teamList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String message = scanner.nextLine();
            String[] messages = message.split(" ");
            int a = Integer.parseInt(messages[0]);
            int b = Integer.parseInt(messages[1]);
            int c = Integer.parseInt(messages[2]);
            if (a > n || b > n) {
                System.out.println("da pian zi");
            }
            if (c == 0) {
                boolean flag = false;
                for (Set team :
                        teamList) {
                    if (team.contains(a) || team.contains(b)) {
                        team.add(a);
                        team.add(b);
                        flag = true;
                    }
                }
                if (!flag) {
                    HashSet<Integer> team = new HashSet<>();
                    team.add(a);
                    team.add(b);
                    teamList.add(team);
                }
            } else if (c == 1) {
                boolean flag = false;
                for (Set team :
                        teamList) {
                    if (team.contains(a) && team.contains(b)) {
                        System.out.println("we are a team");
                        flag = true;
                    }
                }
                if (!flag){
                    System.out.println("we are not a team");
                }
            }else{
                System.out.println("da pian zi");
            }
        }
    }

}
