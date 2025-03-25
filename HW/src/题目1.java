import java.util.*;

public class 题目1 {
    static class student {
        int id;
        int record;
        int minTime = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Map<Integer, student> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] month = new int[30];
        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < 30; i++) {
            month[i] = Integer.parseInt(split[i]);
        }
        for (int i = 1; i <= 30; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                int id = Integer.parseInt(input[j]);
                student student = map.get(id);
                if (student == null) {
                    student = new student();
                    student.id = id;
                    student.minTime = i;
                    student.record = 1;
                    map.put(id, student);
                } else {
                    student.record = student.record + 1;
                    map.put(id, student);
                }

            }
        }
        List<student> students = new ArrayList<>(map.values());
        students.sort((s1, s2) -> {
                    if (s1.record == s2.record) {
                        if (s1.minTime == s2.minTime) {
                            return s1.id - s2.id;
                        } else {
                            return s1.minTime - s2.minTime;
                        }
                    } else {
                        return s2.record - s1.record;
                    }
                }
        );
        StringBuilder result = new StringBuilder();
        if (students.size() <=5 ) {
            for (student student : students) {
                result.append(student.id+" ");
            }
        }else{
            for (int i = 0; i < 5; i++) {
                result.append(students.get(i).id+" ");
            }
        }

        System.out.println(result);
        sc.close();
    }
}
