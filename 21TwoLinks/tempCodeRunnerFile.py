# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 is None:
            l2.next = l1
            return l1
        elif l2 is None:
            l1.next = l2
            return l2
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2



if __name__ == "__main__":
    listNode1 = ListNode(1)
    listNode2 = ListNode(2)
    listNode3 = ListNode(4)

    listNode4 = ListNode(1)
    listNode5 = ListNode(3)
    listNode6 = ListNode(4)

    listNode1.next = listNode2
    listNode2.next = listNode3

    listNode4.next = listNode5
    listNode5.next = listNode6
    so = Solution()    
    print(so.mergeTwoLists(l1, l4))

    

