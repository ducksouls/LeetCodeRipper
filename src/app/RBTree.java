package app;

public class RBTree {

    public static void main(String[] args) {

    }

    Node root;

    /**
     * 左旋 3断,3接
     * 
     * @param x 就是P节点
     */
    public void leftRotate(Node x) {
        // G(爷节点断开P,接上S)
        Node G = x.parent;
        Node S = x.right;
        if (G != null) {
            // x的右孩子,与x替换
            if (G.left == x) {
                G.left = S;
            } else {
                G.right = S;
            }
        }
        S.parent = G;
        // P(P断开指向S,接上a)
        x.right = S.left;
        if (S.left != null)
            S.left.parent = x;

        // S(断开指向a,接上P)
        S.left = x;
        x.parent = S;
    }

    /**
     * 右旋 3断, 3接
     */
    public void rightRotate(Node x) {
        // G跟P断
        Node G = x.parent;
        Node N = x.left;
        if (G != null) {
            if (G.left == x) {
                G.left = x.left;
            } else {
                G.right = x.left;
            }
        }
        // N跟子节点断b
        if (N.right != null)
            N.right.parent = x;
        x.left = N.right;

        // N和P
        x.parent = N;
        N.right = x;
    }

    /**
     * 添加新节点
     */
    void insert(Node newNode) {
        // 1.初始化newNode
        newNode.isRed = true;
        newNode.left = null;
        newNode.right = null;
        newNode.parent = null;

        // root
        if (root == null) {
            root = newNode;
            root.isRed = false;
        } else {
            // 2. 找到放在哪个位置
            Node parent = findParentNode(newNode);
            if (newNode.value >= parent.value) {
                parent.right = newNode;
                newNode.parent = parent;
            } else {
                parent.left = newNode;
                newNode.parent = parent;
            }

            // 3. 修复
            insertFix(newNode);
        }

    }

    /**
     * 插入修正
     */
    void insertFix(Node N) {
        Node P = N.parent;

        // P存在,且P和N两个不能同时为红
        while (P != null && P.isRed) {

        }

    }

    /**
     * 删除
     */
    void remove(Node x) {
    }

    /**
     * 删除修正
     * 
     * @param x
     */
    void removeFix(Node x) {
    }

    Node findParentNode(Node newNode) {
        Node leafNode = root;

        // 一直到叶子节点是null为止
        while (leafNode != null) {
            // 比较
            if (newNode.value >= leafNode.value) {
                if (leafNode.right != null) {
                    leafNode = leafNode.right;
                } else {
                    return leafNode;
                }
            } else {
                if (leafNode.left != null) {
                    leafNode = leafNode.left;
                } else {
                    return leafNode;
                }
            }

        }
        return leafNode;
    }

}

/**
 * 红黑树的节点 True 红色 False 黑色
 */
class Node {
    int value;
    Node parent;
    Node left;
    Node right;
    boolean isRed = true;

    public Node(int value) {
        this.value = value;
    }
}