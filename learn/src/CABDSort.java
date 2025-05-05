import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
//
//输入各类型设备信息列表，需要对其进行排序，若设备的类型是A，则其数据应该在B前面，如果设备的类型是C，则A类设备数据应该在其后面，如果设备的类型是D，则B类型的数据应该在其前面。
//
//请基于java的List和Comparator实现该排序方法，限时20分钟。
//
//设备模型：
//public class Device {
//    private String type;
//
//    private String info;
//
//    public Device(String type) {
//        this.type = type;
//        this.info = "Device Info of " + type;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//}
//
//实现方法：
//public List<Device> sortDevices(List<Device> devices) {
//
//}

public class CABDSort {


    @Test
    public void test() {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("C"));
        devices.add(new Device("A"));
        devices.add(new Device("C"));
        List<Device> sortDevices = sortDevices(devices);
    }


    public static class Device {
        private String type;

        private String info;

        private int sortValue;

        public Device(String type) {
            this.type = type;
            this.info = "Device Info of " + type;
        }

        public String getType() {
            return type;
        }

        public String getInfo() {
            return info;
        }

        public int getSortValue() {
            return sortValue;
        }
    }

    public static List<Device> sortDevices(List<Device> devices) {
//        List<String> order = Arrays.asList("C", "A", "B", "D");
//        devices.sort(Comparator.comparingInt(d -> order.indexOf(d.getType())));
//        return devices;
//        devices.forEach(device -> {
//            if (device.getType().equals("A")) {
//                device.sortValue = 3;
//            } else if (device.getType().equals("B")) {
//                device.sortValue = 2;
//            } else if (device.getType().equals("C")) {
//                device.sortValue = 4;
//            } else if (device.getType().equals("D")) {
//                device.sortValue = 1;
//            }
//        });
//        List<Device> collect = devices.stream().sorted(Comparator.comparingInt(Device::getSortValue).reversed()).collect(Collectors.toList());
//        return collect;
        devices.sort((device1, device2) -> {
            int result = 0;
            String type1 = device1.getType();
            int order1 = 0;
            String type2 = device2.getType();
            int order2 = 0;
            if (type1 == "C") {
                order1 = 4;
            } else if (type1 == "A") {
                order1 = 3;
            } else if (type1 == "B") {
                order1 = 2;
            } else {
                order1 = 1;
            }

            if (type2 == "C") {
                order2 = 4;
            } else if (type2 == "A") {
                order2 = 3;
            } else if (type2 == "B") {
                order2 = 2;
            } else {
                order2 = 1;
            }
            return order1 - order2;
        });
        return devices;


    }

}
