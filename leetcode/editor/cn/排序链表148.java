import org.junit.Test;

import java.util.LinkedList;

public class 排序链表148 {
    @Test

    public void test() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);
        sortList(head);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        LinkedList<ListNode> nodes = new LinkedList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes.sort((a, b) -> a.val - b.val);
        if (nodes.isEmpty()) {
            return head;
        }
        head = new ListNode(nodes.pop().val);
        // 记录长度
        ListNode current = head;
        while (!nodes.isEmpty()) {
            ListNode pop = nodes.pop();
            head.next = pop;
            head = head.next;
        }
        head.next = null;
        return current;
    }
}
