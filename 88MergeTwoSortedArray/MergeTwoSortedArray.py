class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """

        """为什么是and 为什么不是or,想过这个问题吗
        and和or要分具体场景和实现方式
        如果在while中用and(后续没有操作)--->两个数组只有一个遍历完了,那剩下的呢?
        如果在while中使用or(后续没有操作)--->两个数组都需要进行遍历完才能脱离循环,在while中
            可以进行多种边界判断

        思路是正确的,把小的插到最前面,但在实现的方式上有缺陷
        """
        #定义一个数组储存临时数据
        arr = [0 for _ in range(n+m)]
        i = 0
        nums1_index = 0
        nums2_index = 0
        #使用while循环 and/or
        while nums1_index < m or nums2_index < n:
            #边界情况 nums1_index = m和 nums2_index = n
            if nums1_index == m:
                #nums1拷贝完成,将nums2剩下的填入arr中
                arr[i] = nums2[nums2_index]
                nums2_index += 1
            elif nums2_index == n:
                #nums2拷贝完成,将nums1剩下的填入arr中
                arr[i] = nums1[nums1_index]
                nums1_index += 1
            elif nums1[nums1_index] <= nums2[nums2_index]:
                #比较两个数,小的填入arr中
                arr[i] = nums1[nums1_index]
                nums1_index += 1
            else:
                arr[i] = nums2[nums2_index]
                nums2_index += 1
            i += 1
        #将arr 拷贝回 nums1中
        for i in range(len(arr)):
            nums1[i] = arr[i]
        print(arr)


    def merge2(self, nums1, m, nums2, n):
        #反向比较
        #1. 定义两个数组有效长度的位置
        i = m - 1
        j = n - 1
        k = len(nums1) - 1
        #2. 反向遍历 and/or
        while i >= 0 or j >= 0:
            #2. 边界条件i < 0  和 j < 0,至少一个遍历完了
            if i < 0:
                #把nums2剩下的填入
                nums1[k] = nums2[j]
                j -= 1
            elif j < 0:
                #把nums1剩下的填入
                nums1[k] = nums1[i]
                i -= 1
            elif nums1[i] >= nums2[j]:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1
        print(nums1)
if __name__ == "__main__":
    so = Solution()
    so.merge2([4,0,0,0,0,0],
1,
[1,2,3,5,6],
5)