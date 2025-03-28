import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 相交链表160 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode tmp = headA;

        while (tmp != null) {
            listNodes.add(tmp);
            tmp = tmp.next;
        }
        ListNode tmpb = headB;
        while (tmpb != null) {
            if (listNodes.contains(tmpb)) {
                return tmpb;
            }
            tmpb=tmpb.next;
        }
        return null;


    }

}
