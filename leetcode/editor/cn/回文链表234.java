import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class 回文链表234 {
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

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode sc = new ListNode(0);
        ListNode thr = new ListNode(0);
//        ListNode four = new ListNode(1);
        first.next = sc;
        sc.next = thr;
//        thr.next = four;
        isPalindrome(first);
    }

    public static boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int first = 0, last = list.size() - 1;
        if (list.size() == 2) {
            isPalindrome = list.get(first).equals(list.get(last));
        }
        while (list.get(first).equals(list.get(last)) && Math.abs(first - last) > 1) {
            first++;
            last--;
        }
        if (Math.abs(first - last) > 1) {
            isPalindrome = false;
        }
        if (Math.abs(first - last) <= 1) {
            isPalindrome = list.get(first).equals(list.get(last));
        }
        return isPalindrome;

    }
}
