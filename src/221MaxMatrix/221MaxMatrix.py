class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # 遍历每一个点作为左上角
        upLeft = [0, 0]
        maxSide = 0
        result = 0
        maxResutl = 0
        if(len(matrix) == 0):
            return 0
        for x in range(len(matrix)):
            for y in range(len(matrix[0])):
                if(matrix[x][y] == '1'):
                    upLeft = [x, y]
                    maxSide = min(len(matrix[0]) - y, len(matrix) - x)
                    result = self.caculate(upLeft, maxSide, matrix)
                    maxResutl = max(result, maxResutl)
        return maxResutl * maxResutl

    def caculate(self, upLeft, side, matrix):
        """ 计算给定边长的最大面积,全为1
        upLeft: [int,int] 左上角
        sieside 可能的最大边界
        1个点算边长1,2个点算边长2
        """
        isSquare = True
        maxSide = 1

        # 从1开始到给定side
        for i in range(1, side):
            # 判断里面是否全为1
            if(matrix[upLeft[0] + i][upLeft[1] + i] == '0'):
                break
            for j in range(i):
                if(matrix[upLeft[0] + i][upLeft[1] + j] == '0' or matrix[upLeft[0] + j][upLeft[1] + i] == '0'):
                    isSquare = False
            if(not isSquare):
                break
            else:
                maxSide = i + 1
        return maxSide


# [["1","0","1","0","0"],
# ["1","0","1","1","1"],
# ["1","1","1","1","1"],
# ["1","0","0","1","0"]]

if __name__ == "__main__":
    so = Solution()
    squre = so.maximalSquare(
    [[]])
    # matrix = [[1, 1, 1, 0, 0], [1, 1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 0, 0, 1, 0]]
    # side = so.caculate([0, 0], 4, matrix)
    print(squre, '面积')
