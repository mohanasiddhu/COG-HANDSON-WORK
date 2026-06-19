package day02.exercise07;

public class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        for(int i=1;i<=5;i++) ds.makeSet(i);
        ds.union(1,2); ds.union(3,4); ds.union(2,3);
        for(int i=1;i<=5;i++) System.out.println(i+" -> " + ds.find(i));
    }
}
