package day02.exercise07;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private final Map<Integer,Integer> parent = new HashMap<>();
    private final Map<Integer,Integer> rank = new HashMap<>();
    public void makeSet(int x){ parent.put(x,x); rank.put(x,0); }
    public int find(int x){ if(parent.get(x)!=x) parent.put(x, find(parent.get(x))); return parent.get(x); }
    public void union(int x,int y){ int rx=find(x), ry=find(y); if(rx==ry) return; if(rank.get(rx)<rank.get(ry)) parent.put(rx,ry); else if(rank.get(rx)>rank.get(ry)) parent.put(ry,rx); else { parent.put(ry,rx); rank.put(rx, rank.get(rx)+1); } }
}
