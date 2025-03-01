import java.util.*;

public class 智能成绩表 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] split = nextLine.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        String[] xueKeList = scanner.nextLine().split(" ");
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            HashMap<String, Integer> studentMap = new HashMap<>();
            String studentStr = scanner.nextLine();
            String[] split1 = studentStr.split(" ");
            student.name = split1[0];
            for (int j = 0; j < xueKeList.length; j++) {
                int score = Integer.parseInt(split1[j + 1]);
                studentMap.put(xueKeList[j], score);
                student.totalScore += score;
            }
            student.scoreList = studentMap;
            students.add(student);
        }
        String xueKeName = scanner.nextLine();
        students.sort((a, b) -> {
            if (Arrays.asList(xueKeList).contains(xueKeName)) {
                return b.scoreList.get(xueKeName) - a.scoreList.get(xueKeName);
            } else if (a.totalScore == b.totalScore) {
                return a.name.compareTo(b.name);
            } else {
                return b.totalScore - a.totalScore;
            }
        });
        StringBuffer result = new StringBuffer();
        students.forEach(student ->
                result.append(student.name).append(" ")

        );
        System.out.println(result.toString().trim());
    }

    static class Student {
        String name;
        Map<String, Integer> scoreList;
        int totalScore;
    }
}
