package day02.exercise05;

public class AVLTree {
    private Node root;
    static class Node{ int key,height; Node left,right; Node(int k){key=k;height=1;} }

    private int height(Node n){ return n==null?0:n.height; }
    private int balance(Node n){ return n==null?0:height(n.left)-height(n.right); }
    private Node rotateRight(Node y){ Node x=y.left; Node T2=x.right; x.right=y; y.left=T2; y.height=Math.max(height(y.left),height(y.right))+1; x.height=Math.max(height(x.left),height(x.right))+1; return x; }
    private Node rotateLeft(Node x){ Node y=x.right; Node T2=y.left; y.left=x; x.right=T2; x.height=Math.max(height(x.left),height(x.right))+1; y.height=Math.max(height(y.left),height(y.right))+1; return y; }

    public void insert(int key){ root = insert(root,key); }
    private Node insert(Node node,int key){ if(node==null) return new Node(key); if(key<node.key) node.left=insert(node.left,key); else if(key>node.key) node.right=insert(node.right,key); else return node; node.height=1+Math.max(height(node.left),height(node.right)); int balance = balance(node); if(balance>1 && key<node.left.key) return rotateRight(node); if(balance<-1 && key>node.right.key) return rotateLeft(node); if(balance>1 && key>node.left.key){ node.left=rotateLeft(node.left); return rotateRight(node); } if(balance<-1 && key<node.right.key){ node.right=rotateRight(node.right); return rotateLeft(node); } return node; }

    public void inorder(){ inorder(root); System.out.println(); }
    private void inorder(Node n){ if(n==null) return; inorder(n.left); System.out.print(n.key+" "); inorder(n.right); }
}
