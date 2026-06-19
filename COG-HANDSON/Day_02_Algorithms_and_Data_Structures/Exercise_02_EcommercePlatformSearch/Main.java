package day02.exercise02;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchService svc = new SearchService();
        svc.index(new Product("P1","Red Leather Sofa","Comfortable red sofa"));
        svc.index(new Product("P2","Blue Cotton Sofa","Affordable blue sofa"));
        svc.index(new Product("P3","Red Chair","Compact red chair"));
        List<Product> results = svc.search("red");
        System.out.println("Search results for 'red': " + results);
    }
}
