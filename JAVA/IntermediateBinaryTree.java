package JAVA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class IntermediateBinaryTree {
    binaryTree root;
    static class binaryTree{
        int data;
        binaryTree left;
        binaryTree right;
        binaryTree(int data){
            this.data= data;
            this.left=this.right=null;
        }
    }

    public static class Obj{
        binaryTree node;
        int key;

        Obj(binaryTree node ,int key){
            this.node=node;
            this.key=key;
        }
    }
    public static void verticalOrderTraversal(binaryTree root){
        if(root==null)return;
        Queue<Obj> q = new LinkedList<>();
        //int hd=0;
        q.add(new Obj(root, 0));
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        while(!q.isEmpty()){
            binaryTree n = q.peek().node;
            int key = q.poll().key;

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(n.data);
            if(n.left!=null){
                q.add(new Obj(n.left,key-1));
            }
            if(n.right!=null){
                q.add(new Obj(n.right,key+1));
            }
        }

        for(List<Integer> l:map.values()){
            System.out.println(l);
        }
    }

    public static void printSpiralOrder(binaryTree root){

        if(root ==null){
            return ;
        }
        Stack<binaryTree> s1 = new Stack<binaryTree>();
        s1.push(root);
        Stack<binaryTree> s2 = new Stack<binaryTree>();

        while(!s1.isEmpty()||!s2.isEmpty()){
            while(!s1.isEmpty()){
                binaryTree n= s1.pop();
                System.out.println(n.data);

                if(n.right!=null)
                    s2.push(n.right);
                if(n.left!=null)
                    s2.push(n.left);
            }

            while(!s2.isEmpty()){
                binaryTree n = s2.pop();
                System.out.println(n.data);

                if(n.left!=null)s1.push(n.left);
                if(n.right!=null)s1.push(n.right);
            }
        }
    }

    private static void dialgonalTraversal(binaryTree root,HashMap<Integer,ArrayList<Integer>> m,int distance){
        if(root == null)return ;

        List<Integer> l = m.get(distance);
        if(l==null){
            l= new ArrayList<>();
            l.add(root.data);
        }else{
            l.add(root.data);
        }

        m.put(distance,l);

        dialgonalTraversal(root.left, m, distance-1);
        dialgonalTraversal(root.right, m, distance);
    }
    public static void dialgonalTraversalPrint(binaryTree root){
        HashMap<Integer,ArrayList<Integer>> m = new HashMap<>();

        dialgonalTraversal(root,m,0);

    }

    public static void main(String[] args){
        binaryTree root = new binaryTree(1);
        root.left = new binaryTree(2);
        root.right = new binaryTree(3);
        root.left.left = new binaryTree(4);
        root.left.right = new binaryTree(5);
        root.right.left = new binaryTree(6);
        root.right.right = new binaryTree(7);

        //verticalOrderTraversal(root);
        printSpiralOrder(root);

    }
}