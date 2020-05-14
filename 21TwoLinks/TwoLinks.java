import javax.sound.sampled.SourceDataLine;

/**
 * 好好的给我补了一课,java的引用传递 Q:为什么最后返回preHead就可以? A:这个算法的核心思想就是把小节点添加到preHead的后面去,
 * pre起到一个在两个链表中交换的作用preHead和pre除了一开始有联系以外没有什么关系了
 * 
 * Q:怎么改成递归? A:抓住核心思想,将小的留住,大的放在后面,最大的后面肯定就是Null 以此作为递归的结束判断
 */

public class TwoLinks {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. 定义一个头节点
        ListNode preHead = new ListNode(-1);

        // 2. 定义一个临时节点pre
        ListNode pre = preHead;

        // 3. 循环遍历两个链表
        while (l1 != null && l2 != null) {
            // 4. 把小的截取出来,连接到prehead中
            System.out.println("l1:---" + l1.val + "---l2:---" + l2.val);
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
            print(preHead);
        }

        // 5.此时存在可能至多有一个链表没有遍历完
        // 需要把未遍历的部分加上去
        pre.next = l1 != null ? l1 : l2;

        return preHead.next;
    }

    /**
     * 抓住核心思想,留下最小的,大的在后面
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        // 如果为l1.next == null返回
        // l1还有值,等于少比较l1.next并未参与比较

        // 如果l1 == null,直接返回l1
        // 这只能说明是一个列表遍历完毕,但另一个列表里面可能存在值,
        // 并且另一个存在的值一定会大于l1
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }

    }

    public void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val + "print method");
            System.out.println("---------");
            listNode = listNode.next;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        TwoLinks so = new TwoLinks();
        ListNode result = so.mergeTwoLists(null, null);
        System.out.println("----------");
        so.print(result);
        // System.out.println("递归");
        // ListNode recursion = so.mergeTwoListsRecursion(null, null);
        // so.print(recursion);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
