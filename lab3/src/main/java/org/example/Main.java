package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getters for title, author, and year
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // Comparable implementation based on title
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    // Additional methods, if needed
}


class BookService {

    List<Book> getBooksSortedByTitle(List<Book> books) {
        Collections.sort(books);
        return books;
    }


    List<Book> getBooksSortedByYear(List<Book> books) {
        Comparator<Book> byYearComparator = Comparator.comparingInt(Book::getYear);
        books.sort(byYearComparator);
        return books;
    }


    List<Book> getBooksByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }


    double getAveragePublicationYear(List<Book> books) {
        return books.stream()
                .mapToInt(Book::getYear)
                .average()
                .orElse(0.0);
    }


    List<Book> getLatestBooks(List<Book> books, int count) {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getYear).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }
}

class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();

        List<Book> books = List.of(
                new Book("Title3", "Author2", 2000),
                new Book("Title1", "Author1", 1998),
                new Book("Title2", "Author2", 2010),
                new Book("Title4", "Author3", 2005)
        );


        System.out.println("Books sorted by title:");
        bookService.getBooksSortedByTitle(books).forEach(System.out::println);


        System.out.println("\nBooks sorted by year:");
        bookService.getBooksSortedByYear(books).forEach(System.out::println);

        System.out.println("\nBooks by Author2:");
        bookService.getBooksByAuthor(books, "Author2").forEach(System.out::println);

        System.out.println("\nAverage publication year:");
        System.out.println(bookService.getAveragePublicationYear(books));

        System.out.println("\nLatest books:");
        bookService.getLatestBooks(books, 2).forEach(System.out::println);
    }
}
