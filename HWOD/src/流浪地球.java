import java.util.*;

public class 流浪地球 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int[] initInts = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < e; i++) {
            int index = scanner.nextInt();
            int p = scanner.nextInt();
            List<Integer> plist;
            if (map.get(index) == null) {
                plist = new ArrayList<>();
            } else {
                plist = map.get(index);
            }
            plist.add(p);
            map.put(index, plist);
        }
        int initSum = 0;
        List<Integer> nextStartList = new ArrayList<>();

        for (int index = 0; initSum <= n; index++) {
            List<Integer> plist = map.get(index);
            Set<Integer> needStartList = new TreeSet<>();
            if (plist != null && plist.size() > 0) {
                for (Integer p : plist) {
                    if (initInts[p] == 0) {
                        initInts[p] = 1;
                        initSum++;
                        if (p != null) {
                            if (p -  1 < 0 && initInts[n - 1] == 0) {
                                needStartList.add(n - 1);
                            } else if (p - 1 >= 0 && initInts[p - 1] == 0) {
                                needStartList.add(p - 1);
                            }
                            if (p + 1 > n - 1 && initInts[0] == 0) {
                                needStartList.add(0);
                            } else if (p + 1 <= n - 1 && initInts[p + 1] == 0) {
                                needStartList.add(p + 1);
                            }
                        }
                    }

                }
            }


            for (int i = 0; i < nextStartList.size(); i++) {
                Integer t = nextStartList.get(i);
                if (initInts[t] == 0) {
                    initInts[t] = 1;
                    initSum++;
                    if (t != null) {
                        if (t - 1 < 0 && initInts[n - 1] == 0) {
                            needStartList.add(n - 1);
                        } else if (t - 1 >= 0 && initInts[t - 1] == 0) {
                            needStartList.add(t - 1);
                        }
                        if (t + 1 > n - 1 && initInts[0] == 0) {
                            needStartList.add(0);
                        } else if (t + 1 <= n - 1 && initInts[t + 1] == 0) {
                            needStartList.add(t + 1);
                        }
                    }
                }

            }
            if (initSum >= n) {
                StringBuilder builder = new StringBuilder();
                nextStartList.forEach(i -> builder.append(i).append(' '));
                System.out.println(nextStartList.size());
                System.out.println(builder.toString().trim());
                break;
            }
            nextStartList.clear();
            nextStartList.addAll(needStartList);
        }
    }
}

