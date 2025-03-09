import java.util.*;

public class 虚拟理财游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int products = scanner.nextInt();
        int totalMoney = scanner.nextInt();
        int maxFx = scanner.nextInt();
        List<Licai> list = new ArrayList<>();
        for (int i = 0; i < products; i++) {
            Licai licai = new Licai();
            licai.huibaolv = scanner.nextInt();
            list.add(licai);
        }
        for (int i = 0; i < products; i++) {
            Licai licai = list.get(i);
            licai.fengxian = scanner.nextInt();
            list.add(licai);
        }
        for (int i = 0; i < products; i++) {
            Licai licai = list.get(i);
            licai.maxMoney = scanner.nextInt();
            list.add(licai);
        }
        int tmpMaxHb = 0;
        int[] ints = new int[products];
        List<Licai> tempList2 = new ArrayList<>(list);
        for (int i = 0; i < tempList2.size(); i++) {
            Licai ilicai = tempList2.get(i);
            if (ilicai.fengxian <= maxFx) {
                int currMaxHb = ilicai.huibaolv * ilicai.maxMoney;
                if (currMaxHb > tmpMaxHb) {
                    tmpMaxHb = currMaxHb;
                    int[] currInts = new int[products];
                    currInts[i] = ilicai.maxMoney;
                    ints = currInts;
                }
            }
            for (int j = i + 1; j < tempList2.size(); j++) {
                Licai a = tempList2.get(i);
                Licai b = tempList2.get(j);
                if (a.fengxian + b.fengxian <= maxFx) {
                    int aMoney, bMoney;
                    if (a.huibaolv > b.huibaolv) {
                        aMoney = Math.min(a.maxMoney, totalMoney);
                        bMoney = Math.min(totalMoney - aMoney, b.maxMoney);
                    } else {
                        bMoney = Math.min(b.maxMoney, totalMoney);
                        aMoney = Math.min(totalMoney - bMoney, a.maxMoney);
                    }
                    int currMaxHb = b.huibaolv * bMoney + a.huibaolv * aMoney;
                    if (currMaxHb > tmpMaxHb) {
                        tmpMaxHb = currMaxHb;
                        int[] currInts = new int[products];
                        currInts[i] = aMoney;
                        currInts[j] = bMoney;
                        ints = currInts;
                    }
                }

            }


        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < ints.length; i++) {
            result.append(ints[i]).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    static class Licai {
        int huibaolv;
        int fengxian;
        int maxMoney;

        public Licai(int huibaolv, int fengxian, int maxMoney) {
            this.huibaolv = huibaolv;
            this.fengxian = fengxian;
            this.maxMoney = maxMoney;
        }

        public Licai() {
        }
    }
}
