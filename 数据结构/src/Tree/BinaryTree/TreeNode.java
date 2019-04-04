package Tree.BinaryTree;

import java.util.List;

/**
 * 链式二叉树的节点
 */
public class TreeNode {
//树的权（树的值）
private int value;
//树的左节点
private TreeNode leftNode;
//树的右节点
private TreeNode rightNode;

public TreeNode(int value){

    this.value =value;
}


//树的前序遍历方法

    public void frontSort(){
        //先遍历头结点
        System.out.println(value);
        //先序遍历左子树
        if(leftNode!=null){
            leftNode.frontSort();
        }
        //先序遍历右子树
        if(rightNode!=null){
            rightNode.frontSort();
        }

    }


    //树的中序遍历方法
    public void  MidSort(){
        //先中序遍历左子树
        if (leftNode!=null){
            leftNode.MidSort();
        }
        //打印根节点
        System.out.println(value);

        //再中序遍历右子树
        if(rightNode!=null){
            rightNode.MidSort();
        }
    }

    //树的后序遍历方法
    public  void BehindSort(){
    //先后序遍历左子树
        if(leftNode!=null){
            leftNode.BehindSort();
        }
     //再后序遍历右子树
        if(rightNode!=null){
            rightNode.BehindSort();
        }
        //打印根节点
        System.out.println(value);
    }

    //查找根节点
    public  TreeNode fingNode(int i)
    {
        TreeNode target = null;
        //先遍历头结点
         if (i == value){
             return  this;
         }
        //先序遍历左子树
        if(leftNode!=null){
            target=leftNode.fingNode(i);
        }
        if(target!=null){
            return  target;
        }
        //先序遍历右子树
        if(rightNode!=null){
            target= rightNode.fingNode(i);
        }
        if(target!=null){
            return  target;
        }
        return  null;
    }

    //删除节点
    public  void deleteNode(int i){
    if (this.value==i)

       leftNode = null;
       rightNode = null;
    }









    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
