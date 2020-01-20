package com.fight.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * /  \
 * 9   20
 * /   \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0115_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new A0115_MaximumDepthOfBinaryTree().new Solution();
        int[] nums = {3, 9, 20, -1, -1, 15, 7, -1, -1, -1, -1, 8};
        TreeNode root = PrintBinaryTree.createTreeNode(nums);
        int i = solution.maxDepth(root);
        System.out.println(i);
        System.out.println();

        System.out.print("DFS递归先序遍历:   ");
        PrintBinaryTree.preOrder(root);
        System.out.println();

        System.out.print("DFS非递归先序遍历: ");
        PrintBinaryTree.noRecursionPreOrder(root);
        System.out.println();

        System.out.print("DFS递归中序遍历:   ");
        PrintBinaryTree.inOrder(root);
        System.out.println();

        System.out.print("DFS非递归中序遍历: ");
        PrintBinaryTree.noRecursionInOrder(root);
        System.out.println();

        System.out.print("DFS递归后序遍历:   ");
        PrintBinaryTree.postOrder(root);
        System.out.println();

        System.out.print("DFS非递归后序遍历: ");
        PrintBinaryTree.noRecursionPostOrder(root);
        System.out.println();

        System.out.print("BFS遍历: ");
        int depth = PrintBinaryTree.BFS(root);
        System.out.println("  深度:" + depth);
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class PrintBinaryTree {

    /**
     * 前序递归构造二叉树 root->left->right
     *
     * @param scanner 输入流，用于读取节点值
     * @return 构造完成的二叉树的根节点
     */
    public static TreeNode createTreeNode(Scanner scanner) {
        TreeNode root = null;
        int data = scanner.nextInt();
        if (data > 0) {
            root = new TreeNode(data);
            root.left = createTreeNode(scanner);
            root.right = createTreeNode(scanner);
        }
        return root;
    }

    /**
     * 根据数组执行创建二叉树
     *
     * @param array
     * @return
     */
    public static TreeNode createTreeNode(int[] array) {
        return createBinaryTreeByArray(array, 0);
    }

    private static TreeNode createBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value == -1) {
                return null;
            }
            TreeNode treeNode = new TreeNode(value);
            // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+1
            treeNode.left = createBinaryTreeByArray(array, 2 * index + 1);
            treeNode.right = createBinaryTreeByArray(array, 2 * index + 2);
            return treeNode;
        }
        return null;
    }


    // 递归遍历二叉树
    // 先序遍历（前序遍历）
    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }

    // 后序遍历
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + " ");
        }
    }


    // 非递归遍历二叉树 https://www.jianshu.com/p/8efe8f281f22
    // 前序遍历
    public static void noRecursionPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
            while (!stack.empty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 中序遍历
     * 1.如果栈不为空或节点不指向空数据，则执行以下步骤
     * a如果节点不为空，压栈，沿着左子树走一步
     * b如果节点为空，则出栈，打印，沿着右子树走一步
     * 2.如果栈为空且当前节点为空，则结束
     *
     * @param node
     */
    public static void noRecursionInOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    // 后序遍历 ,需要记录遍历过的节点
    public static void noRecursionPostOrder(TreeNode node) {
        TreeNode pre = node;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null) {
            for (; node.left != null; node = node.left) {
                stack.push(node);
            }
            while (node != null && (node.right == null || node.right == pre)) {
                System.out.print(node.val + " ");
                pre = node;
                if (stack.empty()) {
                    return;
                }
                node = stack.pop();
            }
            stack.push(node);
            node = node.right;
        }
    }

    /**
     * 两个栈实现后序遍历
     * 1申请两个栈s1，s2，头节点入栈s1
     * 2如果栈s1不为空，执行以下操作：弹出一个元素，入栈s2，如果该节点左孩子不空入栈s1，如果该节点右孩子不空入栈s1.
     * 3.将栈s2中的节点一次出栈，打印。
     *
     * @param head
     */
    public void posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) {
                s1.push(cur.left);
            }
            if (cur.right != null) {
                s1.push(cur.right);
            }
        }
        while (!s2.isEmpty()) {
            TreeNode cur = s2.pop();
            System.out.println(cur.val);
        }
    }

    /**
     * 一个栈实现后序遍历
     * 后序遍历的难点在于：如何判断上次访问的节点是位于左子树，还是右子树，如果上一个访问的节点是左子树，那么我们则需要先跳过根节点，访问右子树，再返回根节点。
     *
     * @param node
     */
    public void postOrder3(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> s = new Stack<>();

        TreeNode curNode; //当前访问的结点
        TreeNode lastVisitNode; //上次访问的结点
        curNode = node;
        lastVisitNode = null;

        //把currentNode移到左子树的最下边
        while (curNode != null) {
            s.push(curNode);
            curNode = curNode.left;
        }
        while (!s.empty()) {
            curNode = s.pop();  //弹出栈顶元素
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (curNode.right != null && curNode.right != lastVisitNode) {
                //根节点再次入栈
                s.push(curNode);
                //进入右子树，且可肯定右子树一定不为空
                curNode = curNode.right;
                while (curNode != null) {
                    //再走到右子树的最左边
                    s.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                //访问
                System.out.println(curNode.val);
                //修改最近被访问的节点
                lastVisitNode = curNode;
            }
        }
    }


    /**
     * BFS 广度优先搜索
     * 层序遍历二叉树（每一行从左到右，整体上从上到下）
     * 主要思路：利用队列先进先出的性质保存顺序
     *
     * @param node 要遍历的二叉树的根节点
     */
    public static int BFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                System.out.print(tmp.val + " ");
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return depth;
    }


}
