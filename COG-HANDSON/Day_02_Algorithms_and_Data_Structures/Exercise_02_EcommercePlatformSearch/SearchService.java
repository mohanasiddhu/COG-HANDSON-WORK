package day02.exercise02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    private final List<Product> products = new ArrayList<>();
    public void index(Product p){ products.add(p); }
    public List<Product> search(String q){
        String low = q.toLowerCase();
        return products.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(low) || p.getDescription().toLowerCase().contains(low))
                .sorted(Comparator.comparing((Product p)-> relevance(p, low)).reversed())
                .collect(Collectors.toList());
    }
    private int relevance(Product p, String q){
        int score = 0; if (p.getTitle().toLowerCase().contains(q)) score += 10; if (p.getDescription().toLowerCase().contains(q)) score += 2; return score;
    }
}
