package Tree.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * 测试链式二叉树
 */
public class TestBinaryTree {

    public static void main(String[] args) {

          BinaryTree  tree = new BinaryTree();

           tree.setRoot(new TreeNode(1));

          TreeNode root = tree.getRoot();

          root.setLeftNode(new TreeNode(2));
          root.setRightNode(new TreeNode(3));


          root.getLeftNode().setLeftNode(new TreeNode(4));
          root.getLeftNode().setRightNode(new TreeNode(5));

          root.getRightNode().setLeftNode(new TreeNode(6));
          root.getRightNode().setRightNode(new TreeNode(7));

         root.BehindSort();

        TreeNode node = root.fingNode(3);

        System.out.println(node.getValue());

    }



}
