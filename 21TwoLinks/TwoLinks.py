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
        1 -> 2 -> 2 -> 6 -> 11
        1,2,4,5,12
        """
        result  = ListNode(l1.val)
        # 两个节点判断是否为空
        #空说明已经到头了
        while(l1 is not None or l2 is not None):
            # 判断找到最后一个
            if(l2.val >= l1.val and l2.val < l1.next.val ):
                pass
            result = l1

    def merge(self, l1, l2):
        lst = []
        lst.
        l1Temp = None
        l2Temp = None
        if (l2.val >= l1.val and l2.val < l1.next.val ):
            l2Temp = l2.next
            l1Temp = l1.next
            l1.next = l2
            l2.next = l1Temp
        return self.merge(l2, l2Temp)
            
        



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
    print(so.toList(listNode1))

    

