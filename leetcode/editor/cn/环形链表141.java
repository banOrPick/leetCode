import java.util.ArrayList;
import java.util.List;

public class 环形链表141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode sc = new ListNode(2);
        ListNode thr = new ListNode(3);
        ListNode four = new ListNode(4);
        first.next = sc;
        sc.next = thr;
        thr.next = four;
        four.next = first;
        hasCycle(first);
    }

    public static boolean hasCycle(ListNode head) {
               List<ListNode> list = new ArrayList<>();

        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }
}
