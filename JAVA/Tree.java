package JAVA;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static TreeNode root;
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
//Insert node into Binary Tree
    public static void insertNewNode(TreeNode root,int data){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()){
            /*peek() does not remove but
            retrieves the head of this queue , 
            returns null if queue is empty*/
            root=queue.peek();
            queue.remove();//removes data from queue
            if(root.left == null){
                root.left = new TreeNode(data);
                break;
            }
            else{
                queue.add(root.left);
            }

            if(root.right == null){
                root.right = new TreeNode(data);
                break;
            }else{
                queue.add(root.left);
            }
        }
    }
    //inorder traversal
    static void inorderTraversal(TreeNode root){
        if(root == null) return;

        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
//Delete a node from Binary tree
    public static void delteNode(){
        
    }
    
    private static void doLevelOrderTraversal(TreeNode root){
        int level = 1;
        while(levelOrderTraversal(root,level)) level++;
    }
    private static boolean levelOrderTraversal(TreeNode root,int level){
        if(root ==null) return false;
        if(level == 1){
            System.out.println(root.data);
            return true;
        }

        boolean left = levelOrderTraversal(root.left, level-1);
        boolean right = levelOrderTraversal(root.right, level-1);

        return left || right;
    }
    public static void main(String[] args) {
        root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(70);
         root.right.left = new TreeNode(30);
         root.right.right = new TreeNode(40);
       
      //  inorderTraversal(root);
       // insertNewNode(root,100); 
        //inorderTraversal(root);

        //level order using recursion
        doLevelOrderTraversal(root);
    }

}