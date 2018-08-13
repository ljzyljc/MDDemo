package com.finance.jackie.mddemo.tree;

import java.util.Stack;

/**
 * Created by Jackie on 2018/8/13.
 */
public class TreeNodeTest {

    public static TreeNode rootTreeNode = null;

    public TreeNodeTest() {
        rootTreeNode = new TreeNode(1,"A");
    }

    public static void main(String[] args){
        TreeNodeTest treeNodeTest = new TreeNodeTest();
        treeNodeTest.createTreeNode();
        System.out.println(treeNodeTest.getHeight());
        System.out.println(treeNodeTest.getSize(rootTreeNode));

//        treeNodeTest.preOrder(rootTreeNode);
//        treeNodeTest.midOrder(rootTreeNode);
//        treeNodeTest.postOrder(rootTreeNode);

//        treeNodeTest.nonPreOrder(rootTreeNode);
//        treeNodeTest.nonMidOrder(rootTreeNode);
        treeNodeTest.nonPostOrder(rootTreeNode);
    }

    public void createTreeNode(){
        TreeNode treeNodeB = new TreeNode(2,"B");
        TreeNode treeNodeC = new TreeNode(3,"C");
        TreeNode treeNodeD = new TreeNode(4,"D");
        TreeNode treeNodeE = new TreeNode(5,"E");
        TreeNode treeNodeF = new TreeNode(6,"F");
        rootTreeNode.leftChild = treeNodeB;
        rootTreeNode.rightChild = treeNodeC;
        treeNodeB.leftChild = treeNodeD;
        treeNodeB.rightChild = treeNodeE;
        treeNodeC.rightChild = treeNodeF;
    }

    /**
     * 非迭代方式--前序遍历
     * @param treeNode
     */
    public void nonPreOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()){
            //出栈和入栈
            TreeNode node = stack.pop();  //弹出根节点
            System.out.println("--非迭代方式--"+node.getData());
            //压入子节点
            if (node.rightChild != null){
                stack.push(node.rightChild);
            }
            if (node.leftChild != null){
                stack.push(node.leftChild);
            }
        }
    }

    /**
     * 非迭代--中序遍历
     * @param treeNode
     */
//        static class Pair{
//            TreeNode node;
//            int loction;
//
//            public Pair(TreeNode node, int loction) {
//                this.node = node;
//                this.loction = loction;
//            }
//        }

        //中序遍历 迭代实现
//        public void inorderIteration(TreeNode root){
//            Stack<Pair> stack = new Stack<>();
//            stack.push(new Pair(root, 1));
//            while (!stack.isEmpty()){
//                Pair pair = stack.pop();
//                root = pair.node;
//                if (root != null){
//                    switch (pair.loction){
//                        case 1:
//                            stack.push(new Pair(root, 2));
//                            stack.push(new Pair(root.leftChild, 1));
//                            break;
//                        case 2:
//                            System.out.print(root.getData());
//                            stack.push(new Pair(root, 3));
//                            stack.push(new Pair(root.rightChild, 1));
//                            break;
//                        case 3:
//                            break;
//                    }
//                }
//
//            }
//        }

    static class Pair{
        public  int location;
        public  TreeNode node;

        public Pair(int location, TreeNode node) {
            this.location = location;
            this.node = node;
        }
    }

    /**
     * 非迭代--中序遍历
     * @param treeNode
     */
    public void nonMidOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1,treeNode));
        while (!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode root = pair.node;
            if (root != null){
                switch (pair.location){
                    case 1:
                        stack.push(new Pair(2,root));
                        stack.push(new Pair(1,root.leftChild));
                        break;
                    case 2:
                        System.out.println("--中序遍历--"+root.getData());
//                        stack.push(new Pair(3,root));
                        stack.push(new Pair(1,root.rightChild));
                        break;
//                    case 3:
//                        break;
                }
            }
        }
    }
    /**'
     * 非迭代--后序遍历
     */
    public void nonPostOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1,treeNode));
        while (!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode root = pair.node;
            if (root != null){
                switch (pair.location){
                    case 1:
                        stack.push(new Pair(2,root));
                        stack.push(new Pair(1,root.leftChild));
                        break;
                    case 2:
                        stack.push(new Pair(3,root));
                        stack.push(new Pair(1,root.rightChild));
                        break;
                    case 3:
                        System.out.println("postOrder:  "+root.getData());
                        break;

                }

            }


        }



    }















    /**
     * get tree height
     * @return
     */
    public int getHeight(){
        return getHeight(rootTreeNode);
    }

    private int getHeight(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int i = getHeight(treeNode.leftChild);
        int j = getHeight(treeNode.rightChild);
        return i<j ? j+1 : i+1;
    }

    /**
     * get tree all count
     * @param treeNode
     * @return
     */
    public int getSize(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        return 1 + getSize(treeNode.leftChild) + getSize(treeNode.rightChild);
    }

    public void preOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        System.out.println("preOrder : "+treeNode.getData());
        preOrder(treeNode.leftChild);
        preOrder(treeNode.rightChild);
    }
    public void midOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        midOrder(treeNode.leftChild);
        System.out.println("midOrder : "+treeNode.getData());
        midOrder(treeNode.rightChild);
    }
    public void postOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        postOrder(treeNode.leftChild);
        postOrder(treeNode.rightChild);
        System.out.println("postOrder : "+treeNode.getData());
    }




    public class TreeNode{

        public TreeNode(int index, String data) {
            this.index = index;
            this.data = data;
        }

        public int index;
        public String data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }






}
