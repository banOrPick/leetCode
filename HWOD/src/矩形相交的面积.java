import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 矩形相交的面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取矩形信息
        List<int[]> rectangles = readRectangles(scanner);
        // 获取所有矩形的 x 和 y 坐标
        List<Integer> x_coords = getXCoords(rectangles);
        List<Integer> y_coords = getYCoords(rectangles);
        // 计算最小和最大的 x、y 坐标
        int min_x_coord = getMinCoord(x_coords);
        int max_x_coord = getMaxCoord(x_coords);
        int min_y_coord = getMinCoord(y_coords);
        int max_y_coord = getMaxCoord(y_coords);
        // 计算坐标偏移量
        int x_offset = 0 - min_x_coord;
        int y_offset = 0 - min_y_coord;
        // 创建表示矩形区域的二维数组
        int[][] intersection_area = new int[Math.abs(max_x_coord - min_x_coord)][Math.abs(max_y_coord - min_y_coord)];
        // 标记每个矩形覆盖的区域
        markIntersectionArea(rectangles, intersection_area, x_offset, y_offset);
        // 统计三个矩形相交的面积
        int ret = countIntersectionArea(intersection_area);
        // 输出结果
        System.out.println(ret);
        scanner.close();
    }

    // 读取矩形信息
    private static List<int[]> readRectangles(Scanner scanner) {
        List<int[]> rectangles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            int x2 = x1 + w;
            int y2 = y1 - h;
            rectangles.add(new int[]{x1, y1, x2, y2});
        }
        return rectangles;
    }

    // 获取所有矩形的 x 坐标
    private static List<Integer> getXCoords(List<int[]> rectangles) {
        List<Integer> x_coords = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            x_coords.add(rectangle[0]);
            x_coords.add(rectangle[2]);
        }
        return x_coords;
    }

    // 获取所有矩形的 y 坐标
    private static List<Integer> getYCoords(List<int[]> rectangles) {
        List<Integer> y_coords = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            y_coords.add(rectangle[1]);
            y_coords.add(rectangle[3]);
        }
        return y_coords;
    }

    // 计算最小坐标
    private static int getMinCoord(List<Integer> coords) {
        int min = Integer.MAX_VALUE;
        for (int coord : coords) {
            min = Math.min(min, coord);
        }
        return min;
    }

    // 计算最大坐标
    private static int getMaxCoord(List<Integer> coords) {
        int max = Integer.MIN_VALUE;
        for (int coord : coords) {
            max = Math.max(max, coord);
        }
        return max;
    }

    // 标记每个矩形覆盖的区域
    private static void markIntersectionArea(List<int[]> rectangles, int[][] intersection_area, int x_offset, int y_offset) {
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];
            for (int i = Math.min(x2, x1) + x_offset; i < Math.max(x2, x1) + x_offset; i++) {
                for (int j = Math.min(y2, y1) + y_offset; j < Math.max(y2, y1) + y_offset; j++) {
                    intersection_area[i][j] += 1;
                }
            }
        }
    }

    // 统计三个矩形相交的面积
    private static int countIntersectionArea(int[][] intersection_area) {
        int ret = 0;
        for (int i = 0; i < intersection_area.length; i++) {
            for (int j = 0; j < intersection_area[0].length; j++) {
                if (intersection_area[i][j] == 3) {
                    ret += 1;
                }
            }
        }
        return ret;
    }



}
