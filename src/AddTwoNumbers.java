/**
 * Created by hwangfantasy on 2017/8/23.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = l3;
        //mix为两个数字相加的十位数部分
        int mix = 0;
        while (p1 != null || p2 != null) {
            int x = p1 != null ? p1.val : 0;
            int y = p2 != null ? p2.val : 0;
            int sum = mix + x + y;
            p3.next = new ListNode(sum % 10);
            mix = sum / 10;
            p3 = p3.next;
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }
        //最后一位如果大于10需要多加一位
        if (mix > 0) {
            p3.next = new ListNode(mix);
        }
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1,l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
