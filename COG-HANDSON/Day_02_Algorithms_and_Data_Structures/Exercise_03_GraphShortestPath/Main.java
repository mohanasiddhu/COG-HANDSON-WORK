package day02.exercise03;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DijkstraGraph g = new DijkstraGraph();
        g.addEdge("A","B",5); g.addEdge("A","C",2); g.addEdge("C","B",1); g.addEdge("B","D",3);
        Map<String,Integer> dist = g.shortestPath("A");
        System.out.println("Distances from A: " + dist);
    }
}
