import java.util.*;

/**
 * 4
 * 3
 * 2 1 2
 * 2 3 3
 * 4 2 4
 * 2
 * 3
 */
public class 电脑病毒感染 {
    static class Computer {
        int id;
        int nextId;
        int time;

        public Computer(int id, int nextId, int time) {
            this.id = id;
            this.nextId = nextId;
            this.time = time;
        }

        public Computer() {
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Computer[] computers = new Computer[m];
        for (int i = 0; i < m; i++) {
            computers[i] = new Computer();
            computers[i].id = scanner.nextInt();
            computers[i].nextId = scanner.nextInt();
            computers[i].time = scanner.nextInt();
        }
        int currentId = scanner.nextInt();
        HashSet<Integer> ganRanSet = new HashSet<>();
        List<Computer> currentComputerList = getComputerList(currentId, computers);
        ganRanSet.add(currentId);
        int i = 0;
        while (currentComputerList.size() != 0) {
            int min = ganRanMin(currentComputerList);
            currentComputerList = ganRan(currentComputerList, ganRanSet, computers);
            i += min;

        }
        if (ganRanSet.size() == n) {
            System.out.println(i);
        } else {
            System.out.println(-1);
        }


    }

    private static List<Computer> getComputerList(int currentId, Computer[] computers) {
        List<Computer> currentComputerList = new ArrayList<>();
        for (int i = 0; i < computers.length; i++) {
            if (computers[i].id == currentId) {
                currentComputerList.add(computers[i]);
            }
        }
        return currentComputerList;
    }

    private static Integer ganRanMin(List<Computer> currentComputerList) {
        int min = Integer.MAX_VALUE;
        for (Computer computer : currentComputerList) {
            min = Math.min(min, computer.time);
        }
        return min;
    }

    private static List<Computer> ganRan(List<Computer> currentComputerList, HashSet<Integer> ganRanSet, Computer[] computers) {
        int min = Integer.MAX_VALUE;
        for (Computer computer : currentComputerList) {
            min = Math.min(min, computer.time);
        }
        List<Computer> tmpComputerList = new ArrayList<>(currentComputerList);
        for (Computer computer : currentComputerList) {
            if (min == computer.time) {
                tmpComputerList.remove(computer);
                List<Computer> list = getComputerList(computer.nextId, computers);
                tmpComputerList.addAll(list);
                ganRanSet.add(computer.nextId);
            } else {
                tmpComputerList.remove(computer);
                computer.time = computer.time - min;
                tmpComputerList.add(computer);
            }
        }
        return tmpComputerList;
    }


}
