package JAVA;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    //private TreeNode root;
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

    public TreeNode searchAndInsert(TreeNode root, int key){
        if(root == null){
            root = new TreeNode(key);
            return root;
        }

        if(root.data > key){
            searchAndInsert(root.left, key);
        }else if(root.data < key){
            searchAndInsert(root.right, key);
        }
        return root;
    }

    public void doLevelOrderTraversal(TreeNode root){
       // int level=1;
       
    }
    public static void levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            System.out.println(n.data);
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }

        }

    }
    public static void main(String[] arg){
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(45);
        root.right = new TreeNode(55);
        root.left.left = new TreeNode(44);
        root.left.right = new TreeNode(46);
        root.right.left = new TreeNode(54);
        root.right.right = new TreeNode(56);

        levelOrder(root);
    }
}