package org.javafeature.bookrecommendation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookRecommendationSystem {

    public List<BookRecommendation> getRecommendations(List<Book> books, int page) {


        // filter book
        List<BookRecommendation> recommendations = books.stream()
                .filter(book -> "Science Fiction".equalsIgnoreCase(book.getGenre()) && book.getRating() > 4.0)
                .map(book -> new BookRecommendation(book.getTitle(), book.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed()) // Step 3: Sort by rating
                .collect(Collectors.toList());

        int pageSize = 5;
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, recommendations.size());

        if (fromIndex >= recommendations.size() || fromIndex < 0) {
            return Collections.emptyList();
        }

        return recommendations.subList(fromIndex, toIndex);
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("AAAA", "ZZZ", "Science Fiction", 4.5),
                new Book("BBBB", "YYY", "Science Fiction", 4.2),
                new Book("CCCC", "XXX", "Science Fiction", 4.6),
                new Book("DDDD", "WWW", "Science Fiction", 4.0)
                );
        BookRecommendationSystem system = new BookRecommendationSystem();
        List<BookRecommendation> recommendations = system.getRecommendations(books, 1);
        recommendations.forEach(System.out::println);
    }
}
