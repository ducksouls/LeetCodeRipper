package app;

public class FriendCircle {

    public static void main(String[] args) {
        FriendCircle so = new FriendCircle();
        // 条件1.方阵,对角线必定为1,所以必初始有n个朋友圈
        int[][] source = { {} };

        int result = so.findCircleNum(source);
        System.out.println(result);
    }

    // 朋友间有传递性
    public int findCircleNum(int[][] M) {
        // 遍历M,找到一个为1的位置(i,j)
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j <= i; j++) {
                // 有朋友关系才去寻找朋友(自己和自己算作朋友)
                if (M[i][j] == 1) {
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] source, int i, int j) {
        // 这一竖或者这一行都是(i,j)的朋友

        // 把(i,j)标0

        // 顺着一个朋友继续找,直到不满足条件
        return 1;
    }

}