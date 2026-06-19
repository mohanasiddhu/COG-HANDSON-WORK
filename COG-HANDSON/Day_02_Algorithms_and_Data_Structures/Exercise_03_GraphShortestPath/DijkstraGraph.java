package day02.exercise03;

import java.util.*;

public class DijkstraGraph {
    private final Map<String, List<Edge>> adj = new HashMap<>();
    public void addEdge(String u,String v,int w){ adj.computeIfAbsent(u,k->new ArrayList<>()).add(new Edge(v,w)); }
    public Map<String,Integer> shortestPath(String src){
        Map<String,Integer> dist = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.dist));
        dist.put(src,0); pq.add(new Node(src,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll(); if (cur.dist!=dist.get(cur.id)) continue;
            for (Edge e: adj.getOrDefault(cur.id, Collections.emptyList())){
                int nd = cur.dist + e.weight;
                if (nd < dist.getOrDefault(e.to,Integer.MAX_VALUE)){
                    dist.put(e.to, nd); pq.add(new Node(e.to, nd));
                }
            }
        }
        return dist;
    }
    static class Edge{ final String to; final int weight; Edge(String t,int w){to=t;weight=w;} }
    static class Node{ final String id; final int dist; Node(String id,int d){this.id=id;this.dist=d;} }
}
