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
        lst1 = self.toList(l1)
        lst2 = self.toList(l2)
        result = []
        length = len(lst1) if len(lst1) >= len(lst2) else len(lst2) 
        for i in range(length):
            
    def toList(self, listNode):
        flag = True
        lst = []
        while flag:
            if listNode is not None:
                lst.append(listNode.val)
            if(listNode.next is not None):
                listNode = listNode.next
            else:
                flag  = False
        return lst
        



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

    

