import java.util.ArrayList;
import java.util.List;

public class 环形链表Ⅱ142 {
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
        detectCycle(first);
    }

    public static ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            if (list.contains(head)) {
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }
}
