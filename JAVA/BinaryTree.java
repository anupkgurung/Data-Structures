package JAVA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
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

    private static void levelOrderTraversalUsingQueue(TreeNode root){

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode n = q.peek();
            System.out.println(n.data); 
            q.remove();
            if(n.left != null) q.add(n.left);
            if(n.right!=null) q.add(n.right);

        }
    }

    private static void preOrderTraversal(TreeNode root){
        if(root==null) return;

        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        
    }
     //inorder traversal
    private static void inOrderTraversal(TreeNode root){
        if(root == null) return;

        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(TreeNode root){
        if(root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    private static void inOrderIterative(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            root =s.pop();//removes the node from top of stack

            //stack is LIFO so right child is pushed first
            //so that left can be processed first.
            if(root.right !=null){
                s.push(root.right);
            }
            System.out.println(root.data);
            if(root.left != null)
                s.push(root.left); 
        }
    }
    private static void preOrderIterative(TreeNode root){
        Stack<TreeNode> s =new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            //return the node from top of stack but does not remove it
            root = s.peek();
            s.pop();

            System.out.println(root.data);
            if(root.left!=null){
                s.push(root.left);
            }
            if(root.right!=null){
                s.push(root.right);
            }
        }
    }
    private static void postOrderIterative(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> s0 = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode n=s.pop();
            s0.push(n);
            if(n.left!=null){
                s.push(n.left);
            }
            if(n.right!=null)
                s.push(n.right);
        }
    }

    private static void levelOrderReverse(TreeNode root){
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        Stack<TreeNode> s=new Stack<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode n = q.remove();
            s.push(n);
            if(n.left!=null)
                q.add(n.left);
            if(n.right!=null)
                q.add(n.right);            
        }
        while(!s.isEmpty()){
            TreeNode n=s.pop();
            System.out.println(n.data);
        }
    }

    private static boolean searchInBinaryTree(TreeNode root, int value){
        if(root==null)return false;
        
        if(root.data == value)return true;

        if(root.left!=null){
            if(searchInBinaryTree(root.left,value))
                return true;
        }
        if(root.right!=null){
            if(searchInBinaryTree(root.right,value))
                return true;
        }
        return false;
    }

    private static int findMaxHeightDepth(TreeNode root){
        if(root==null)return 0;
            int leftHeight = findMaxHeightDepth(root.left);
            int rightHeight= findMaxHeightDepth(root.right);

            if(leftHeight>rightHeight)
                return leftHeight+1;
            else 
            return rightHeight +1;
        
    }
    private static void mirrorTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Queue<TreeNode> q0 = new LinkedList<>();

        while(!q.isEmpty()){
            TreeNode n= q.poll();
            q0.add(n);
            if(root.right!=null)
                q.add(root.right);

            if(root.left!=null){
                q.add(root.left);
            }
        }
    }
    public static void main(String[] args) {
        root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(70);
         root.right.left = new TreeNode(30);
         root.right.right = new TreeNode(40);
     
       // insertNewNode(root,100); 

       //doLevelOrderTraversal(root);//level order using recursion
       //levelOrderTraversalUsingQueue(root); //level order using Queue
      // System.out.println("preOrder");
      // preOrderTraversal(root);
      // System.out.println("inOrder");
       //inOrderTraversal(root);
      // System.out.println("PostOrder");
       //postOrderTraversal(root);
       //levelOrderReverse(root);
      // System.out.println(searchInBinaryTree(root,150));
      //System.out.println(findMaxHeightDepth(root));
    }

}