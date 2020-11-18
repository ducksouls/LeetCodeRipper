class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        my_dict = dict(zip(nums,range(len(nums))))
        print(my_dict)
        for index,num in enumerate(nums):
            j = my_dict.get(target-num)
            if j is not None and j != index:
                return [index, j]


if __name__ == "__main__":
    so = Solution()
    print(so.twoSum([],6))
