import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 手机App防沉迷系统 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<App> apps = new ArrayList<App>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            App app = new App();
            app.app = split[0];
            app.level = Integer.parseInt(split[1]);
            app.startTime = Integer.parseInt(split[2].split(":")[0]) * 60 + Integer.parseInt(split[2].split(":")[1]);
            app.endTime = Integer.parseInt(split[3].split(":")[0]) * 60 + Integer.parseInt(split[3].split(":")[1]);
            if (app.startTime < app.endTime) {
                apps.add(app);
            }

        }
        apps = registeApp(apps);
        String inputTime = scanner.nextLine();
        int time = Integer.parseInt(inputTime.split(":")[0]) * 60 + Integer.parseInt(inputTime.split(":")[1]);
        String appName = getApp(apps, time);
        System.out.println(appName);
        scanner.close();
    }

    private static String getApp(List<App> apps, int time) {

        List<App> first = apps.stream().filter(app -> time > app.getStartTime() && time < app.getEndTime()).collect(Collectors.toList());
        if (first == null || first.size() == 0) {
            return "NA";
        } else {
            return first.get(0).getApp();
        }
    }

    private static List<App> registeApp(List<App> apps) {
        apps.sort(Comparator.comparing(App::getStartTime));
        for (int i = 0; i < apps.size() - 1; i++) {
            App leftApp = apps.get(i);
            App rightApp = apps.get(i + 1);
            if (leftApp.getEndTime() > rightApp.getStartTime()) {
                if (leftApp.getLevel() < rightApp.getLevel()) {
                    apps.remove(leftApp);
                } else {
                    apps.remove(rightApp);
                }

            }
        }
        return apps;
    }

    static class App {
        String app;
        int level;
        int startTime;
        int endTime;

        public App(String app, int level, int startTime, int endTime) {
            this.app = app;
            this.level = level;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public App() {
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

}
