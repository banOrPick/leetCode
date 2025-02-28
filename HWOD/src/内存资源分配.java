import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class 内存资源分配 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String inputString2 = scanner.nextLine();
        List<Memory> memories = getMemoryList(inputString);
        StringBuffer result = new StringBuffer();
        String[] split = inputString2.split(",");
        for (int i = 0; i < split.length; i++) {
            String size = split[i];
            Boolean flag = false;
            for (int j = 0; j < memories.size(); j++) {
                Memory m = memories.get(j);
                if (m.getSize() >= Integer.parseInt(size)) {
                    flag = true;
                    if (m.getNum() > 1) {
                        Memory memory = new Memory();
                        memory.setNum(m.getNum() - 1);
                        memory.setSize(m.getSize());
                        memories.set(j, memory);
                        break;
                    } else {
                        memories.remove(m);
                    }
                }
            }
            result.append(flag.toString()).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    private static List<Memory> getMemoryList(String inputString) {
        List<Memory> memories = new ArrayList<>();
        String[] memorys = inputString.split(",");
        for (int i = 0; i < memorys.length; i++) {
            Memory memory = new Memory();
            String[] split = memorys[i].split(":");
            memory.size = Integer.parseInt(split[0]);
            memory.num = Integer.parseInt(split[1]);
            memories.add(memory);
        }
        return memories.stream().sorted(Comparator.comparing(Memory::getSize)).collect(Collectors.toList());
    }

    static class Memory {
        int size;
        int num;

        public Memory(int size, int num) {
            this.size = size;
            this.num = num;
        }

        public Memory() {
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
