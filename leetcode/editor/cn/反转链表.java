import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 反转链表 {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode sc = new ListNode(2);
        ListNode thr = new ListNode(3);
        ListNode four = new ListNode(4);
        first.next = sc;
        sc.next = thr;
        thr.next = four;
        reverseList(first);
    }

    public static class ListNode {
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

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> list = new Stack<>();
        while (head != null) {
            list.push(head);
            head = head.next;
        }
        ListNode result = new ListNode();
        if (list.isEmpty()) {
            return null;
        }
        result = list.pop();
        ListNode  tmp=result;
        result.next=null;
        while (!list.isEmpty()) {
            ListNode next = list.pop();
            next.next = null;
            result.next = next;
            result = next;
        }
        return tmp;
    }
}


