import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 构成正方形的数量 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Point p) {
            return this.x ==
                    p.x && this.y == p.y;
        }

        static Boolean isZFX(Point p1, Point p2, Point p3, Point p4) {
            if (mathMo(p1, p4) == mathMo(p2, p3) && mathMo(p1, p2) == mathMo(p1, p3)&&mathMo(p2, p4) == mathMo(p3, p4)&&mathMo(p1, p2) == mathMo(p2, p4)) {
                return true;
            }
            if (mathMo(p1, p2) == mathMo(p3, p4) && mathMo(p1, p3) == mathMo(p1, p4)&&mathMo(p1, p3) == mathMo(p2, p3)&&mathMo(p2, p3) == mathMo(p2, p4)) {
                return true;
            }
            if (mathMo(p1, p3) == mathMo(p2, p4) && mathMo(p1, p2) == mathMo(p1, p4)&&mathMo(p1, p2) == mathMo(p2, p3)&&mathMo(p3, p2) == mathMo(p3, p4)) {
                return true;
            }
            return false;

        }

        static double mathMo(Point p1, Point p2) {
            return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<4){
            System.out.println(0);
        }
        List<Point> points = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }
        int result=0;
        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                for (int k = j+1; k < n-1; k++) {
                    for (int  l= k+1; l < n; l++) {
                        if(Point.isZFX(points.get(i),points.get(j),points.get(k),points.get(l))){
                            result++;
                        }

                    }
                }
            }
        }
        System.out.println(result);


    }
}
