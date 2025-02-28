import java.util.Scanner;

public class 矩形相交的面积 {
    static class Point{
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static class JuXin{
        public Point lh;
        public Point rh;
        public Point ll;
        public Point rl;

        public JuXin(Point lh, Point rh, Point ll, Point rl) {
            this.lh = lh;
            this.rh = rh;
            this.ll = ll;
            this.rl = rl;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String three = scanner.nextLine();
        JuXin juXin = getJuXin(first);
        JuXin juXi2 = getJuXin(first);
        JuXin juXi3 = getJuXin(first);
    }
    static JuXin ProcessJuxin(JuXin juXin1,JuXin juXin2){
        JuXin juXin = null;

        return juXin;
    }

    static JuXin getJuXin(String first){
        String[] s = first.split(" ");
        double x=Double.parseDouble(s[0]);
        double y=Double.parseDouble(s[1]);
        double w=Double.parseDouble(s[2]);
        double h=Double.parseDouble(s[3]);
        JuXin juXin = null;
        if(w>0&&h>0){
            Point lh = new Point(x,y);
            Point rh = new Point(x+w,y);
            Point ll = new Point(x,y-h);
            Point rl = new Point(x+w,y-h);
            juXin= new JuXin(lh, rh, ll, rl);
        }
        if(w>0&&h<0){
            Point lh = new Point(x,y-h);
            Point rh = new Point(x+w,y-h);
            Point ll = new Point(x,y);
            Point rl = new Point(x+w,y);
            juXin= new JuXin(lh, rh, ll, rl);
        }
        if(w<0&&h<0){
            Point lh = new Point(x+w,y-h);
            Point rh = new Point(x,y-h);
            Point ll = new Point(x+w,y);
            Point rl = new Point(x,y);
            juXin= new JuXin(lh, rh, ll, rl);
        }
        return juXin;
    }
}
