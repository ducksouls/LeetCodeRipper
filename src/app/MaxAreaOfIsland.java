package app;

import java.util.Arrays;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland so = new MaxAreaOfIsland();

        int[][] source = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }

        };

        int result = so.maxAreaOfIsland(source);
        System.out.println(result);
    }

    /**
     * dfs两个要素 栈:用栈来保存当前节点信息，当遍历新节点返回时能够继续遍历当前节点。也可以使用递归栈。 标记:需要对已经遍历过得节点进行标记。
     */

    // 两遍循环
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        // 遍历每一个点找到岛屿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {// 直到找到陆地再开始搜索
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }
        return area;
    }

    // dfs,这里是系统帮我们压栈(递归)
    public int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // “先污染后治理”的方法，先做递归调用，再在每个 DFS 函数的开头判断坐标是否合法，不合法的直接返回。
        // 边界
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 0;
        // 保险
        if (grid[i][j] == 0)
            return 0;
        // 打上遍历过得标记
        grid[i][j] = 0;
        return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}