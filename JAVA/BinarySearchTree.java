package JAVA;

public class BinarySearchTree {

    private TreeNode root;
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
    public static void main(String[] arg){
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(45);
        root.right = new TreeNode(55);
        root.left.left = new TreeNode(44);
        root.left.right = new TreeNode(46);
        root.right.left = new TreeNode(54);
        root.right.right = new TreeNode(56);
    }
}