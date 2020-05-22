package cn.lai.leetcoderipper.list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}

public class MergeTwoLinks {
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        System.out.println();
        MergeTwoLinks so = new MergeTwoLinks();
        ListNode result = so.mergeTwoLists(l1, l4);
        System.out.println(result);

    }

}
