public class 爬楼梯 {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        int sum = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
