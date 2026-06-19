package day02.exercise05;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] keys = {10,20,30,40,50,25};
        for(int k: keys) tree.insert(k);
        System.out.print("Inorder traversal: "); tree.inorder();
    }
}
