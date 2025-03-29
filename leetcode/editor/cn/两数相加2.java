public class 两数相加2 {

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
        ListNode first1 = new ListNode(9);
        ListNode sc1 = new ListNode(9);
        ListNode thr1 = new ListNode(9);
//        ListNode four = new ListNode(1);
        first1.next = sc1;
        sc1.next = thr1;
//        thr.next = four;

        ListNode first2 = new ListNode(9);
        ListNode sc2 = new ListNode(9);
        ListNode thr2 = new ListNode(9);
        ListNode four2 = new ListNode(9);
        first2.next = sc2;
        sc2.next = thr2;
        thr2.next = four2;
        addTwoNumbers(first1, first2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode firstNode = l1;
        ListNode secondNode = l2;
        ListNode temp = new ListNode();
        ListNode head = temp;
        head.val = ((firstNode == null?0:firstNode.val) + (secondNode == null?0:secondNode.val))%10;
        int last=((firstNode == null?0:firstNode.val) + (secondNode == null?0:secondNode.val))/10;
        while (firstNode.next != null || secondNode.next != null) {
            ListNode next=new ListNode();
            firstNode = firstNode.next==null?new ListNode():firstNode.next ;
            secondNode = secondNode.next==null?new ListNode():secondNode.next;
            next.val = ((firstNode == null?0:firstNode.val) + (secondNode == null?0:secondNode.val))%10+last;
            if(next.val>=10){
                next.val=next.val-10;
                last=((firstNode == null?0:firstNode.val) + (secondNode == null?0:secondNode.val))/10+1;
            }else{
                last=((firstNode == null?0:firstNode.val) + (secondNode == null?0:secondNode.val))/10;
            }
            temp.next = next;
            temp=temp.next;
        }
        if(last!=0){
            ListNode next=new ListNode();
            next.val=last;
            temp.next = next;
            temp=temp.next;
        }
        return head;
    }
}
